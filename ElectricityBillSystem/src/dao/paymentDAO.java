package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.PaymentBean;
import util.DBConnection;
/**
 *  paynow functionality is implemented here.
 */
public class paymentDAO {
	
	public static boolean payNow(PaymentBean payUser) throws Exception{
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE bills SET status = ? WHERE bill_id = ? AND user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		/**
		 * loading the data onto the ps object:
		 */
		ps.setString(1, "success");
		ps.setString(2, payUser.getBill_Id());
		ps.setString(3, payUser.getUser_Id());
		int k=ps.executeUpdate();
		return k>0;
		
	}

}
