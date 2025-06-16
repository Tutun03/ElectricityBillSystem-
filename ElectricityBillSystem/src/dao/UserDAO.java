package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UserBean;

import util.DBConnection;

/**
 * login,getUserbyId and register functionality is implemented here.
 */
public class UserDAO {

	public static boolean registerUser(UserBean user) throws Exception {

		Connection con = DBConnection.getConnection();

		String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, user.getConsumerId());

		ps.setInt(2, user.getBillNumber());

		ps.setString(3, user.getCustomerName());

		ps.setString(4, user.getEmail());

		ps.setLong(5, user.getMobileNo());

		ps.setString(6, user.getUserId());

		ps.setString(7, user.getPassword());

		ps.setString(8, user.getConfirmpassword());

		return ps.executeUpdate() > 0;

	}

	/**
	 *  Fetch user by userId (used to check if user exists)
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static UserBean getUserById(String userId) throws Exception {
		try (Connection con = DBConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setConsumerId(rs.getLong("consumer_id"));

				return user;
			}
		}
		return null;

	}

	/**
	 *  Optional shortcut: fetch user if userId and password both match
	 * @param userId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static UserBean loginUser(String userId, String password) throws Exception {
		try (Connection con = DBConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE user_id=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getString("user_id"));
				user.setConsumerId(rs.getLong("consumer_id"));
				return user;
			}
		}
		return null;

	}

	public static boolean isValidConsumer(long cid) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * from register_consumer where consumerId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		String cid1 = Long.toString(cid);
		ps.setString(1, cid1);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
}