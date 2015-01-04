package Data;


import java.sql.*;

/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class interfaces with the CANCorder database to get the values of the variables the interface is displaying. 
 * 
 */

public class CANCorder {
	// Constants for connecting to the database
	private final String DB_URL = "jdbc:mysql://localhost:3306/";
	private final String DB_NAME = "CANCorder";
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_USER_NAME = "rider_display"; 
	private final String DB_PASSWORD = "current";
	
	private Connection connection;

	
	public CANCorder() {
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER_NAME, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// This method will get the value of the passed variable by querying the CANCorder database. Right now it just generates a value for demo purposes.
	public static double getValue(String variableName) {
		
		double value = 0;
		return value;
	}
}
