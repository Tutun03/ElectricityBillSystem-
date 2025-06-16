package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.RegisterConsumerbean;

import util.DBConnection;
/** 
 * register Consumer functionality is implemented here
 */
public class registerConsumerDAO {
	public static boolean registerConsumer(RegisterConsumerbean r_u) throws Exception
	{
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO register_consumer VALUES (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, r_u.getConsumerId());
		return ps.executeUpdate() > 0;
	}
}
