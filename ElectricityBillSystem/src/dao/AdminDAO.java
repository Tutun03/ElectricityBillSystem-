package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Adminbean;
import util.DBConnection;

/**
 * login admin functionality is implemented hereS
 */
public class AdminDAO {



public static Adminbean loginAdmin(String adminId, String password) throws Exception {
	Connection con=DBConnection.getConnection();
	String sql="SELECT * FROM admins where admin_id=? AND password=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, adminId);
	ps.setString(2, password);
	ResultSet rs=ps.executeQuery();
    if(rs.next())
	{
		Adminbean admin=new Adminbean();
		admin.setAdminId(adminId);
		admin.setName(rs.getString("name"));
		return admin;
		
	}
	return null;
}
}

