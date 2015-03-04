package com.airforecast.util;

/**
 * Wind Direction constants
 * 
 * @author Aruna
 * 
 */
public enum WindDirectionENum {

	N(11.25), NNE(33.75), NE(56.25), ENE(78.75), E(101.25), ESE(123.75), SE(
			146.25), SSE(168.75), S(191.25), SSW(213.75), SW(236.25), WSW(
			258.75), W(281.25), WNW(303.75), NW(326.25), NNW(348.75);

	double value;

	private WindDirectionENum(double direction) {
		value = direction;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

}
