package org.faceftw.foilsimremastered.types;

import org.faceftw.foilsimremastered.Constants.Airfoil;
import org.faceftw.foilsimremastered.math.Convert;
import org.faceftw.foilsimremastered.math.Convert.Units;

public class KuttaCirculation {
	
	private double thet;
	private double rdm;
	private double thtm;
	private double beta;
	private int index;
	private double xcval;
	private Airfoil foil;
	private double ycval;
	private double camval;
	private double rval;
	private double thkval;
	private double gamval;
	private double alfval;
	private double radius;
	private double spin;
	private double spindir;
	private double vfsd;
	private double nptc;
	private Units unit;
	
	//Geometry stuff. Seperating to prevent any confusion during debugging
	private double[][] xg0;
	private double[][] yg0;
	private double[][] rg0;
	private double[][] thg;
	private double[][] xm;
	private double[][] ym;
	private double[] plp;
	private double[] plv;
	
	private double xt1;
	private double yt1;
	private double xt2;
	private double yt2;
	private double spanfac;
	
	
	/**
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param _radius the radius to set
	 */
	public void setRadius(double _radius) {
		radius = _radius;
	}

	/**
	 * @return thet
	 */
	public double getThet() {
		return thet;
	}

	/**
	 * @param _thet the thet to set
	 */
	public void setThet(double _thet) {
		thet = _thet;
	}

	/**
	 * @return rdm
	 */
	public double getRdm() {
		return rdm;
	}

	/**
	 * @param _rdm the rdm to set
	 */
	public void setRdm(double _rdm) {
		rdm = _rdm;
	}

	/**
	 * @return thtm
	 */
	public double getThtm() {
		return thtm;
	}

	/**
	 * @param _thtm the thtm to set
	 */
	public void setThtm(double _thtm) {
		thtm = _thtm;
	}

	/**
	 * @return beta
	 */
	public double getBeta() {
		return beta;
	}

	/**
	 * @param _beta the beta to set
	 */
	public void setBeta(double _beta) {
		beta = _beta;
	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param _index the index to set
	 */
	public void setIndex(int _index) {
		index = _index;
	}

	/**
	 * @return xcval
	 */
	public double getXcval() {
		return xcval;
	}

	/**
	 * @param _xcval the xcval to set
	 */
	public void setXcval(double _xcval) {
		xcval = _xcval;
	}

	/**
	 * @return foil
	 */
	public Airfoil getFoil() {
		return foil;
	}

	/**
	 * @param _foil the foil to set
	 */
	public void setFoil(Airfoil _foil) {
		foil = _foil;
	}

	/**
	 * @return ycval
	 */
	public double getYcval() {
		return ycval;
	}

	/**
	 * @param _ycval the ycval to set
	 */
	public void setYcval(double _ycval) {
		ycval = _ycval;
	}

	/**
	 * @return camval
	 */
	public double getCamval() {
		return camval;
	}

	/**
	 * @param _camval the camval to set
	 */
	public void setCamval(double _camval) {
		camval = _camval;
	}

	/**
	 * @return rval
	 */
	public double getRval() {
		return rval;
	}

	/**
	 * @param _rval the rval to set
	 */
	public void setRval(double _rval) {
		rval = _rval;
	}

	/**
	 * @return thkval
	 */
	public double getThkval() {
		return thkval;
	}

	/**
	 * @param _thkval the thkval to set
	 */
	public void setThkval(double _thkval) {
		thkval = _thkval;
	}

	/**
	 * @return gamval
	 */
	public double getGamval() {
		return gamval;
	}

	/**
	 * @param _gamval the gamval to set
	 */
	public void setGamval(double _gamval) {
		gamval = _gamval;
	}

	/**
	 * @return alfval
	 */
	public double getAlfval() {
		return alfval;
	}

	/**
	 * @param _alfval the alfval to set
	 */
	public void setAlfval(double _alfval) {
		alfval = _alfval;
	}

	public KuttaCirculation(){
		
	}
	
	public void calculateValues() {
		switch(foil) {
		case JUOKOWSKI:
			ycval = camval / 2.0 ;
            rval = thkval/4.0 +Math.sqrt(thkval*thkval/16.0+ycval*ycval +1.0);
            xcval = 1.0 - Math.sqrt(rval*rval - ycval*ycval) ;
            beta = Convert.RadtoDeg(Math.asin(ycval/rval)) ;     /* Kutta condition */
            gamval = 2.0*rval*Math.sin(Convert.DegtoRad((alfval+beta))) ;
            break ;
		case ELLIPTICAL:
			ycval = camval / 2.0 ;
            rval = thkval/4.0 + Math.sqrt(thkval*thkval/16.0+ycval*ycval+1.0);
            beta = Convert.RadtoDeg(Math.asin(ycval/rval)) ;    /* Kutta condition */
            gamval = 2.0*rval*Math.sin(Convert.DegtoRad((alfval+beta))) ;
			break;
		case PLATE:
			ycval = camval / 2.0 ;
            rval = Math.sqrt(ycval*ycval+1.0);
            beta = Convert.RadtoDeg(Math.asin(ycval/rval)) ;    /* Kutta condition */
            gamval = 2.0*rval*Math.sin(Convert.DegtoRad(alfval+beta)) ;
			break;
		case ROT_CYLINDER:
		case ROT_BALL:
			//Apparently, the original foilsim has these two conditions split up during Kutta Calcualtions.
			//Yet the code remains the same
			//Keeping a note for this atm, will look for discrepancy when testing
			rval = Convert.convLength(radius, unit);
            gamval = 4.0 * 3.1415926 * 3.1415926 *spin * rval * rval/(Convert.convVelocity(vfsd, unit));
            gamval = gamval * spindir ;
            ycval = .0001 ;
			break;
		default:
			break;
		
		}
		
		//Seperated geometry calculations because its just messy man
		createGeometry();
	}
	
	public void createGeometry() {
		//This may get kinda messy
		//TODO Do stuff with this method
		
		for(index = 1; index <= nptc; index++) {
			thet = (index - 1) * 360./(nptc-1);
			
		}
	}

}
