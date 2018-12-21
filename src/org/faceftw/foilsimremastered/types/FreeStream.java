package org.faceftw.foilsimremastered.types;

import org.faceftw.foilsimremastered.Constants;
import org.faceftw.foilsimremastered.Constants.AtmosphereLayer;
import org.faceftw.foilsimremastered.Constants.Planet;

/* FreeStream Class
 * =================
 * Given the nature of the original Foilsim code being very mixed
 * around, it makes sense to reorganize some of the calculations
 * and variables to ensure it is accurate as the project continues.
 * 
 * This represents the data returned by the solver from getFreeStream()
 */

public class FreeStream {

	//Variables (Oh boy, here we go)
	private double height;				//Altitiude
	private double pvap;				//Something about vaopor	
	private double ts0;					//Unknown purpose (Most likely temp)
	private double ps0;					//Unknown purpose (Possibly pressure
	private double temf;				//Unknown purpose (most likely temp (kelvin unit)
	private double rho;					//Air Density (I think)
	private double viscos;				//Viscosity (maybe)
	private double rlhum; 				//Unknown purpose, used with Mars data

	private Planet planet;

	//TODO Check the purposes for ts0,ps0,temf,rho,pvap


	//Constructor with parameters (Definitely may need more objects
	public FreeStream(Planet p, double alt ) {
		planet = p;
		height = alt;
	}


	/* Getter and Setter Methods
	 * ================================
	 */



	/**
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param _height the height to set
	 */
	public void setHeight(double _height) {
		height = _height;
	}

	/**
	 * @return pvap
	 */
	public double getPvap() {
		return pvap;
	}

	/**
	 * @param _pvap the pvap to set
	 */
	public void setPvap(double _pvap) {
		pvap = _pvap;
	}

	/**
	 * @return ts0
	 */
	public double getTs0() {
		return ts0;
	}

	/**
	 * @param _ts0 the ts0 to set
	 */
	public void setTs0(double _ts0) {
		ts0 = _ts0;
	}

	/**
	 * @return ps0
	 */
	public double getPs0() {
		return ps0;
	}

	/**
	 * @param _ps0 the ps0 to set
	 */
	public void setPs0(double _ps0) {
		ps0 = _ps0;
	}

	/**
	 * @return temf
	 */
	public double getTemf() {
		return temf;
	}

	/**
	 * @param _temf the temf to set
	 */
	public void setTemf(double _temf) {
		temf = _temf;
	}

	/**
	 * @return rho
	 */
	public double getRho() {
		return rho;
	}

	/**
	 * @param _rho the rho to set
	 */
	public void setRho(double _rho) {
		rho = _rho;
	}

	/**
	 * @return viscos
	 */
	public double getViscos() {
		return viscos;
	}

	/**
	 * @param _viscos the viscos to set
	 */
	public void setViscos(double _viscos) {
		viscos = _viscos;
	}

	/**
	 * @return rlhum
	 */
	public double getRlhum() {
		return rlhum;
	}

	/**
	 * @param _rlhum the rlhum to set
	 */
	public void setRlhum(double _rlhum) {
		rlhum = _rlhum;
	}

	/**
	 * @return planet
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * @param _planet the planet to set
	 */
	public void setPlanet(Planet _planet) {
		planet = _planet;
	}

	//Called during construction or after a value is changed
	public void calculateValues() {
		switch(planet) {
		case EARTH:
			AtmosphereLayer currentLayer = findAtmosphereLayer();
			switch(currentLayer) {
			case TROPHOSPHERE:
				ts0 = 518.6 - 3.56 * height/1000.;
				ps0 = 2116. * Math.pow(ts0/518.6,5.256);
				break;
			case STRATOSPHERE:
				ts0 = 389.98 ;
				ps0 = 2116. * .2236 * Math.exp((36000.-height)/(53.35*389.98)) ;
				break;
			case MESOSPHERE:
				ts0 = 389.98 + 1.645 * (height-82345)/1000.;
				ps0 = 2116. *.02456 * Math.pow(ts0/389.98,-11.388) ;
				break;
			}
			//Temperature stuff
			temf = ts0 - 459.6 ;
			if (temf <= 0.0) temf = 0.0 ; 
			rho = ps0/(Constants.EARTH_IDEAL_GAS_CONSTANT * ts0) ;

			// Eq 1:6A  Domasch  - effect of humidity 

			pvap = rlhum*(2.685+.00354*Math.pow(temf,2.245))/100.;
			rho = (ps0 - .379*pvap)/(Constants.EARTH_IDEAL_GAS_CONSTANT * ts0) ; 
			viscos = Constants.MU0_AIR * 717.408/(ts0 + 198.72)*Math.pow(ts0/518.688,1.5) ;
			break;
		case MARS:
			
			break;
		case TWO:
			
			break;
		case THREE:
			
			break;
		case FOUR:
			
			break;
		case VENUS:
			
			break;
		}
	}

	//Used to determine the atmosphere layer given altitude
	public AtmosphereLayer findAtmosphereLayer() {
		AtmosphereLayer out = AtmosphereLayer.TROPHOSPHERE;
		if(height <= 36152.) {
			out = AtmosphereLayer.TROPHOSPHERE;
		}
		if(height >= 36152. && height <= 82345.) {
			out = AtmosphereLayer.STRATOSPHERE;
		}
		if(height >= 82345.) {
			out = AtmosphereLayer.MESOSPHERE;
		}
		return out;
	}

}
