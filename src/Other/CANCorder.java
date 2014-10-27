package Other;
/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class interfaces with the CANCorder database to get the values of the variables the interface is displaying. 
 * 
 */

public class CANCorder {

	// This method will get the value of the passed variable by querying the CANCorder database. Right now it just generates a value for demo purposes.
	public static double getValue(String variableName, double lastValue) {
		
		double value = lastValue + 1;
		return value;
	}
}
