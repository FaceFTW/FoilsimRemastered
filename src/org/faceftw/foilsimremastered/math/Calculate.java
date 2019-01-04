package org.faceftw.foilsimremastered.math;

public class Calculate {
	//This class just holds some static methods for various calculations I felt did not fit with the objects
	
	//public double[] getVel( Params still pending atm)
	//This returns calculations for the velocity & pressure and any bundled vars I feel necessary
	public double[] getVel(double rad, double theta) {
		//Vars not in the method that are needed for calculation **COMMENTEED FOR ORGANIZATION PURPOSES**
		//double rval
		//double gamval
		//double xcval
		//double ycval
		//double usq
		//double vsq
		
		//A bunch of vars here ohboy
		double ur;
		double uth;
		double jake1;
		double jake2;
		double jakesq;
		double xloc;
		double yloc;
		
		//I have high confidence that these two vars are only needed throughout this method
		double thrad;
		double alfrad;
		
		//Variables that will be returned in the Array (In order descending for the index of the value)
		double vel;			//Index 0
		double pres;		//Index 1
		double usq;			//Index 2
		double vsq;			//Index 3
		double vxdir;		//Index 4
		
		
		
		
		
		//Placeholder return to not trigger eclipse
		return new double[]{0};
	}
}
