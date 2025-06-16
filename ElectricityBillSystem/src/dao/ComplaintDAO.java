package dao;

import beans.ComplaintBean;
import util.DBConnection;
import java.sql.*;
/**
 * complaintdao registercomplaint and getcomplaintById functionality implemented here.
 */
public class ComplaintDAO {
	public static boolean registerComplaint(ComplaintBean complaint) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO complaints(complaint_id, user_id, complaint_type, description, mobile_no, contact_person, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, complaint.getComplaintId());
		ps.setString(2, complaint.getUserId());
		ps.setString(3, complaint.getComplaintType());
		ps.setString(4, complaint.getDescription());
		ps.setString(5, complaint.getMobileNo());
		ps.setString(6, complaint.getContactPerson());
		ps.setString(7, complaint.getAddress());
		return ps.executeUpdate() > 0;
	}

	public static ComplaintBean getComplaintById(String complaintId, String userId) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM complaints WHERE complaint_id=? AND user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, complaintId);
		ps.setString(2, userId);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			ComplaintBean complaint = new ComplaintBean();
			complaint.setComplaintId(complaintId);
			complaint.setUserId(rs.getString("user_id"));
			complaint.setComplaintType(rs.getString("complaint_type"));
			complaint.setDescription(rs.getString("description"));
			complaint.setMobileNo(rs.getString("mobile_no"));
			complaint.setContactPerson(rs.getString("contact_person"));
			complaint.setAddress(rs.getString("address"));
			complaint.setStatus(rs.getString("status"));
			return complaint;
		}
		return null;

	}
}
