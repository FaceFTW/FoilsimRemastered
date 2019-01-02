package org.faceftw.foilsimremastered.math;

/* Convert Class
 * ========================= 
 * As mentioned in other files, the overall organization for methods is needed,
 * in efforts for efficiency and understanding the code. 
 * 
 * This class has a bunch of static methods for common converstions
 */

public class Convert {
	
	public enum Units{FREEDOM,METRIC}
	
	//Some conversion factors
	private static final double D2R = Math.PI/180.;					//Degrees to Radians
	private static final double HALF_PI = Math.PI/2.0;				//Constant for Pi/2
	
	//For Freedom Units given input data
	private static final double FREEDOM_LENGTH_MOD  = 1;			//Feet
	private static final double FREEDOM_VELOCITY_MOD =.6818;		//mph
	private static final double FREEDOM_WEIGHT_MOD = 1.0;			//lbs
	private static final double FREEDOM_PRESSURE_MOD = 14.7;		//lb/(in^2)
	
	//For Metric Units given input data
	private static final double METRIC_LENGTH_MOD = .3048;			//meters
	private static final double METRIC_VELOCITY_MOD = 1.097;		//km/hr
	private static final double METRIC_WEIGHT_MOD = 4.448;			//Newtons
	private static final double METRIC_PRESSURE_MOD = 101.3;		//kPa
	

	
	//Converting Degrees to Radians
	public static double DegtoRad(double in) {
		return in*D2R;
	}
	
	//Converting Radians to Degrees
	public static double RadtoDeg(double in) {
		return in/D2R;
	}
	

	public static double convLength(double in, Units u) {
		double out = 0.;
		switch(u) {
		case FREEDOM:
			out = in*FREEDOM_LENGTH_MOD;
			break;
		case METRIC:
			out = in*METRIC_LENGTH_MOD;
			break;
		}
		return out;
	}
	
	/* double convVelocity(double, Units)
	 * Converts Velocity to the respective units
	 */
	public static double convVelocity(double in, Units u) {
		double out = 0;
		switch(u) {
		case FREEDOM:
			out = in * FREEDOM_VELOCITY_MOD;
			break;
		case METRIC:
			out = in * METRIC_VELOCITY_MOD;
			break;
		}
		return out;
	}
	
	/* double convWeight(double, Units)
	 * Converts Pressure to the respective units
	 */
	public static double convWeight(double in, Units u) {
		double out = 0.;
		switch(u) {
		case FREEDOM:
			out = in * FREEDOM_WEIGHT_MOD;
			break;
		case METRIC:
			out = in * METRIC_WEIGHT_MOD;
		}
		return out;
	}
	
	/* double convPressure(double, Units)
	 * Converts Pressure to the respective units
	 */
	public static double convPressure(double in, Units u) {
		double out = 0;
		switch(u) {
		case FREEDOM:
			out = in * FREEDOM_PRESSURE_MOD;
			break;
		case METRIC:
			out = in * METRIC_PRESSURE_MOD;
		}
		return out;
	}
}
