package com.airforecast.model;

public class NormalizedHeatmap {

	private String lat;

	private String lng;

	private String count;

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng
	 *            the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * @param lat
	 * @param lng
	 * @param count
	 */
	public NormalizedHeatmap(String lat, String lng, String count) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.count = count;
	}

	/**
	 * 
	 */
	public NormalizedHeatmap() {
		super();
		// TODO Auto-generated constructor stub
	}

}
