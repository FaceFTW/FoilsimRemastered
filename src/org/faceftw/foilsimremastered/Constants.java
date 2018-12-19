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
	
	
	//What are those? 
	//TODO Research These

}
