package util;

import java.sql.Connection;

import java.sql.DriverManager;

/**
 *  this util function is use to establish connection to the Derby database.
 */
public class DBConnection {

public static Connection getConnection() throws Exception {

Class.forName("org.apache.derby.jdbc.ClientDriver");

return DriverManager.getConnection("jdbc:derby://localhost:1527/electricity;create=true", "user", "123");

}

}