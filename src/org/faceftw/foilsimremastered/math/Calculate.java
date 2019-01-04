package org.faceftw.foilsimremastered.math;

import org.faceftw.foilsimremastered.Constants.Airfoil;

public class Calculate {
	//This class just holds some static methods for various calculations I felt did not fit with the objects
	
	//public double[] getVel( Params still pending atm)
	//This returns calculations for the velocity & pressure and any bundled vars I feel necessary
	public double[] getVel(double rad, double theta, Airfoil foil) {
		//Vars not in the method that are needed for calculation **COMMENTEED FOR ORGANIZATION PURPOSES**
		double rval;
		double gamval;
		double xcval;
		double ycval;
		//double usq;
		//double vsq;
		double alfval;
		
		//A bunch of vars here ohboy
		double ur = 0;
		double uth = 0;
		double jake1 = 0;
		double jake2 = 0;
		double jakesq = 0;
		double xloc = 0;
		double yloc = 0;
		
		//I have high confidence that these two vars are only needed throughout this method
		double thrad;
		double alfrad;
		
		//Variables that will be returned in the Array (In order descending for the index of the value)
		double vel = 0;			//Index 0, Velocity
		double pres = 0;		//Index 1, Pressure
		double usq;				//Index 2, Something Squared
		double vsq;				//Index 3, Velocity Squared
		double vxdir;			//Index 4, Velocity Direction?
		
		
		thrad = Convert.DegtoRad(theta);
		alfrad = Convert.DegtoRad(alfval);
		
		//Get x,y location in cylinder plane
		xloc = rad * Math.cos(thrad);
		yloc = rad * Math.sin(thrad);
		
		//Velocity in Cylinder Plane
		ur = Math.cos(thrad-alfrad) * (1.0-(Math.pow(rval, 2)/Math.pow(rad, 2)));
		uth = -Math.sin(thrad-alfrad) * (1.0 + (Math.pow(rval, 2)/Math.pow(rad, 2))) - gamval/rad;
		
		//Unknown atm
		usq = Math.pow(ur, 2) + Math.pow(uth, 2);
		vxdir = ur * Math.cos(thrad) - uth * Math.sin(thrad);
		
		//Translation for generating the airfoil
		xloc += xcval;
		yloc += ycval;
		
		//Compute the new radius-theta
		rad = Math.sqrt(Math.pow(xloc, 2) + Math.pow(yloc, 2));
		thrad = Math.atan2(yloc, xloc);
		
		//Compute Joukowski Jacobian thing
		jake1 = 1.0 - Math.cos(2.0 * thrad)/Math.pow(rad, 2);
		jake2 = Math.sin(2.0 * thrad)/Math.pow(rad, 2);
		jakesq = Math.pow(jake1, 2) + Math.pow(jake2, 2);
		
		//Bounds protection
		if(Math.abs(jakesq) <= .01) {
			jakesq = .01;
		}
		
		vsq = usq/jakesq;
		
		//vel is velocity ratio
		//pres is coefficient (p-p0)/q0
		
		
		switch(foil) {
			case JUOKOWSKI:
			case ELLIPTICAL:
			case PLATE:
				vel = Math.sqrt(vsq);
				pres = 1.0 - vsq;
				break;
			case ROT_BALL:
			case ROT_CYLINDER:
				vel = Math.sqrt(usq);
				pres = 1.0 - usq;
				break;
			default:
				break;
		}
		
		//Placeholder return to not trigger eclipse
		return new double[]{vel, pres};
	}
}
