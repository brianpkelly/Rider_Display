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
	private final static String DB_URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "CANCorder";
	private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_USER_NAME = "cancorder"; 
	private final static String DB_PASSWORD = "current";
	
	// String constants for CAN variable names, used in the Layout objects
	public final static String RPM = "rpm";
	public final static String TIRE_PRESSURE = "tire_pressure";
	public final static String BATTERY_VOLTAGE = "batt_volt";
	
	private Connection connection;

	
	public CANCorder() {
		try {
			Class.forName(DB_DRIVER);
			this.connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER_NAME, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// This method will get the value of the passed variable by querying the CANCorder database. Right now it just generates a value for demo purposes.
	public double getValue(String variableName) {
		
		double value = 0;
		
		try {
			if (!this.connection.isClosed()) {
				String query = 	"SELECT Value FROM CANTime  WHERE CAN_Message = \"" + variableName + "\" ORDER  BY Time DESC LIMIT 1;";
				ResultSet results = this.connection.createStatement().executeQuery(query);
				if (results.next()) {
					value = Double.parseDouble(results.getString(1));
	            }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return value;
	}
}
