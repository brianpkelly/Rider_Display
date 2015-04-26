package Data;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;


/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class interfaces with the CANCorder database to get the values of the variables the interface is displaying. 
 * 
 */

public class CANCorder {
	
	// Directory where files are located
	private final static String DIR = "/home/cancorder/";
	
	// String constants for CAN variable names, used in the Layout objects
	public final static String RPM = "rpm";
	public final static String TIRE_PRESSURE = "tire_pressure";
	public final static String BATTERY_VOLTAGE = "batt_volt";
	public final static String FRONT_TIRE_TEMPERATURE = "FrontTireTemp";
	public final static String THROTTLE = "MotorCurrentSetpoint";
	public final static String LOCK = "Locked";
	
	
	// Integer constants to indicate errors with the data
	public final static int ERROR_MISSING_DATA = -1;
	public final static int  ERROR_OLD_DATA = -2;
	
	private RandomAccessFile reader;
	private String variableName;
	private byte[] bytes;
	
	public CANCorder(String variableName) {
		
		this.variableName = variableName;
		this.bytes = new byte[8];
		try {
			this.reader = new RandomAccessFile(new File(DIR + "data/" + variableName), "r");
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
			reader.seek(0);
			reader.read(bytes);
			time = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getDouble();
			reader.read(bytes);
			value = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getDouble();
			//System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_MISSING_DATA;
		}
		
		return value;
	}
	
	public double[] getMinMax() {
		
		double min = 0;
		double max = 0;
		
		try {
			//System.out.println(reader.readLine());
			//System.out.println(reader.readLine());
			Scanner s = new Scanner(new File(DIR + "meta/" + variableName));
			min = s.nextDouble();
			max = s.nextDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		double[] minMax = {min, max};
		return minMax;
	}
}
