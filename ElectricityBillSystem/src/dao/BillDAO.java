package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.BillBean;
import util.DBConnection;

/**
 * BillDAO addbill, paybill, getpendingbill
 * functionality implemented.
 */
public class BillDAO {
	public boolean addBill(BillBean bill) {
		boolean result = false;
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO bills (user_id, bill_no, amount, status) VALUES (?, ?, ?, ?)");) {

			ps.setString(1, bill.getuser_id());
			ps.setString(2, bill.getbill_no());
			ps.setDouble(3, bill.getAmount());
			ps.setString(4, bill.getStatus());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 *  to pay the bill
	 * by the user
	 */
	public boolean payBill(String bill_id) {
		boolean result = false;
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE bills SET status='paid' WHERE bill_id = ?");) {

			ps.setString(1, bill_id);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 *  To fetch the bill
	 */
	public List<BillBean> getPendingBills(String user_id) {
		List<BillBean> list = new ArrayList<>();
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con
						.prepareStatement("SELECT * FROM bills WHERE user_id=? AND status='pending'");) {

			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BillBean bill = new BillBean();
				bill.setbill_id(rs.getString("bill_id"));
				bill.setuser_id(rs.getString("user_id"));
				bill.setbill_no(rs.getString("bill_no"));
				bill.setAmount(rs.getDouble("amount"));
				bill.setStatus(rs.getString("status"));
				list.add(bill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}