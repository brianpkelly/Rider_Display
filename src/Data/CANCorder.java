package Data;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;


/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class interfaces with the CANCorder database to get the values of the variables the interface is displaying. 
 * 
 */

public class CANCorder {
	
	// Directory where files are located
	private final static String DIR = "/home/cancorder/data/";
	
	// String constants for CAN variable names, used in the Layout objects
	public final static String RPM = "rpm";
	public final static String TIRE_PRESSURE = "tire_pressure";
	public final static String BATTERY_VOLTAGE = "batt_volt";
	public final static String FRONT_TIRE_TEMPERATURE = "FrontTireTemp";
	
	// Integer constants to indicate errors with the data
	public final static int ERROR_MISSING_DATA = -1;
	public final static int  ERROR_OLD_DATA = -2;
	
	private RandomAccessFile reader;
	
	public CANCorder(String variableName) {
		try {
			this.reader = new RandomAccessFile(new File(DIR + variableName), "r");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// This method will get the value of the passed variable by querying the CANCorder database. Right now it just generates a value for demo purposes.
	public double getValue() {
		
		double time = 0;
		double value = 0;
		
		try {
			//System.out.println(reader.readLine());
			//System.out.println(reader.readLine());
			time = reader.readDouble();
			value = reader.readDouble();
			reader.seek(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
}
