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
	public enum Planet{EARTH, MARS, WATER, THREE, FOUR, VENUS}
	
	
	//Enum for representing the different layers of the Earth's atmosphere
	public enum AtmosphereLayer{TROPHOSPHERE, STRATOSPHERE, MESOSPHERE}
	
	//Enum for representing the different Altitudes relative toward Mars' Orbit
	//Value reference is 22960 (mi?)
	public enum MarsAtmosphereLayer{BELOW_VAL, ABOVE_VAL}
	
	//Gravity Stuff
	public static final double EARTH_GRAVITY = 32.2; // feet/(second^2)
	
	//Ideal Gas Stuff? (It does make sense with PV=nRT)
	//TODO Find any equations relating to the Ideal Gas Constant Involved (R)
	public static final double EARTH_IDEAL_GAS_CONSTANT = 1716.;
	public static final double MARS_IDEAL_GAS_CONSTANT = 1149.;
	public static final double VENUS_IDEAL_GAS_CONSTANT = 1149.;
	
	//Maximum Velocity Constants
	public static final double FREEDOM_VELOCITY_MAX = 250.;			//mph, Unknown purpose atm
	public static final double METRIC_VELOCITY_MAX = 400.;			//km/hr
	
	//Maximum Force Constants
	public static final double FREEDOM_WEIGHT_MAX = 100000.;		//lbs
	public static final double FREEDOM_WEIGHT_MAX_B = .5;			//lbs
	public static final double METRIC_WEIGHT_MAX = 500000.;			//Newtons
	public static final double METRIC_WEIGHT_MAX_B = 2.5;			//Newtons
	
	//Coefficients of friction
	public static final double MU0_AIR = .000000362;				//Most Likely Coefficient of Friction
	public static final double MU0_WATER = .0000272;				//Coefficient of Friction for Water
		
	//rlhum constants (probably relative humidity)
	public static final double RLHUM_WATER = 100.;
	public static final double RLHUM_MARS = 0.0;
	public static final double RLHUM_VENUS = 0.0;
	public static final double RLHUM_MISC = 0.0;
	
	//Density (Rho) Constants
	public static final double RHO_WATER = 1.94;					//Still figuring out units
	
	
	//Mars Related Constants
	//Freedom Units 
	public static final double MARS_FREEDOM_VELOCITY_MAX = 50.;		//mph
	
	//Metric Units
	public static final double MARS_METRIC_VELOCITY_MAX = 80.;		//km/hr

	
	
	
	//What are those? 
	//TODO Research These
	public static final double EARTH_GAMA = 1.4;					//Unknown
	public static final double MARS_GAMA = 1.29;					//Unknown
	public static final double VENUS_GAMA = 1.29;					//Unknown
}
