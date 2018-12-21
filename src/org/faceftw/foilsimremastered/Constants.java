package org.faceftw.foilsimremastered;

/* Constants Class
 * 
 * In my efforts to attempt to reorganize the Foilsim code,
 * I need to reorganize the code for my understanding.
 * 
 * This is just a basic skeleton for holding a bunch of constant values
 */

public class Constants {	
	//Order of the enums are the same as the int values of planet in original Foilsim
	public enum Planet{EARTH, MARS, THREE, FOUR, VENUS}
	
	//Gravity Stuff
	public static final double EARTH_GRAVITY = 32.2; // feet/(second^2)
	
	//Ideal Gas Stuff? (It does make sense with PV=nRT)
	//TODO Find any equations relating to the Ideal Gas Constant Involved (R)
	public static final double EARTH_IDEAL_GAS_CONSTANT=1716.;
	
	
	
	//Maximum Velocity Constants
	private static final double FREEDOM_VELOCITY_MAX = 250.;		//mph, Unknown purpose atm
	private static final double METRIC_VELOCITY_MAX = 400.;			//km/hr
	
	//Maximum Force Constants
	private static final double FREEDOM_WEIGHT_MAX = 100000.;		//lbs
	private static final double FREEDOM_WEIGHT_MAX_B = .5;			//lbs
	private static final double METRIC_WEIGHT_MAX = 500000.;		//Newtons
	private static final double METRIC_WEIGHT_MAX_B = 2.5;			//Newtons

	
	//Mars Related Constants
	//Freedom Units 
	private static final double MARS_FREEDOM_VELOCITY_MAX = 50.;	//mph
	
	//Metric Units
	private static final double MARS_METRIC_VELOCITY_MAX = 80.;		//km/hr

	
	//What are those? 
	//TODO Research These

}
