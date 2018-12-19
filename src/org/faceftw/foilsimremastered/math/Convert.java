package org.faceftw.foilsimremastered.math;

import org.faceftw.foilsimremastered.Constants.Planet;

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
	private static final double PID2 = Math.PI/2.0;					//Unknown at the moment
	
	//For Freedom Units given input data
	private static final double FREEDOM_LENGTH_MOD  = 1;			//Feet
	private static final double FREEDOM_VELOCITY_MOD =.6818;		//mph
	private static final double FREEDOM_VELOCITY_MAX = 250.;		//mph, Unknown purpose atm
	private static final double FREEDOM_WEIGHT_MOD = 1.0;			//lbs
	private static final double FREEDOM_WEIGHT_MAX = 100000.;		//lbs
	private static final double FREEDOM_WEIGHT_MAX_B = .5;			//lbs
	private static final double FREEDOM_PRESSURE_MOD = 14.7;		//lb/(in^2)
	
	//For Metric Units given input data
	private static final double METRIC_LENGTH_MOD = .3048;			//meters
	private static final double METRIC_VELOCITY_MOD = 1.097;		//km/hr
	private static final double METRIC_VELOCITY_MAX = 400.;			//km/hr
	private static final double METRIC_WEIGHT_MOD = 4.448;			//Newtons
	private static final double METRIC_WEIGHT_MAX = 500000.;		//Newtons
	private static final double METRIC_WEIGHT_MAX_B = 2.5;			//Newtons
	private static final double METRIC_PRESSURE_MOD = 101.3;		//kPa
	
	
	//Mars Related Constants
	//Freedom Units 
	private static final double MARS_FREEDOM_VELOCITY_MAX = 50.;	//mph
	
	//Metric Units
	private static final double MARS_METRIC_VELOCITY_MAX = 80.;		//km/hr

	
	//Converting Degrees to Radians
	public static double DegtoRad(double in) {
		return in*D2R;
	}
	
	//Unknown Conversion, temporary placeholder
	public static double convPid2(double in) {
		return in*PID2;
	}

	public static double convLength(double in,Units u) {
		switch(u) {
		case FREEDOM:
			return in*FREEDOM_LENGTH_MOD;
		case METRIC:
			return in*
		}
	}
	
	public static double convVelocity(Planet p,double in, Units u) {
		double out = 0;
		switch(p) {
		case EARTH:
			out = in/FREEDOM_VELOCITY_MOD;
			break;
		case MARS:
			
			break;
		}
		return in/FREEDOM_VELOCITY_MOD;
	}
}
