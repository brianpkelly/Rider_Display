package Data;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class interfaces with the CANCorder database to get the values of the variables the interface is displaying. 
 * 
 */

public class CANCorder2 {
	
	// Directory where files are located
	private final static String DIR = "/home/cancorder/data/";
	
	// String constants for CAN variable names, used in the Layout objects
	public final static String RPM = "rpm";
	public final static String TIRE_PRESSURE = "tire_pressure";
	public final static String BATTERY_VOLTAGE = "batt_volt";

	// This method will get the value of the passed variable by querying the CANCorder database. Right now it just generates a value for demo purposes.
	public double getValue(String variableName) {
		
		File dataFile = new File(DIR + variableName);
		Scanner scan;
		double time = 0;
		double value = 0;
		
		try {
			scan = new Scanner(dataFile);
			time = scan.nextDouble();
			value = scan.nextDouble();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return value;
	}
}
