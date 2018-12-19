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
	
	
	//Some conversion factors
	private static final double d2r = Math.PI/180.;				//Degrees to Radians
	private static final double pid2 = Math.PI/2.0;				//Unknown at the moment
	
	//For Freedom Units given input data
	private static final double freedom_length_mod = .1; 		//Feet
	private static final double freedom_velocity_mod=.6818;		//mph
	private static final double freedom_velocity_max=250.;		//mph, Unknown purpose atm
	
	
	

	
	//Converting Degrees to Radians
	public static double DegtoRad(double in) {
		return in*d2r;
	}
	
	//Unknown Conversion, temporary placeholder
	public static double convPid2(double in) {
		return in*pid2;
	}

	public static double toFreedomLength(double in) {
		return in/freedom_length_mod;
	}
	
	public static double toFreedomVelocity(Planet p,double in) {
		double out = 0;
		switch(p) {
		case EARTH:
			out = in/freedom_velocity_mod;
			break;
		case MARS:
			break;
		}
		return in/freedom_velocity_mod;
	}
}
