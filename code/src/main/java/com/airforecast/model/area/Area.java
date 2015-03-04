package com.airforecast.model.area;
import org.junit.Ignore;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Area")  
public class Area {
	private String code;
	private String areaName;
	private String cityName;
	private double latitude;
	private double longitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
//	@Transient
//	public GeoLocation getGeoLocation() {
//		return new GeoLocation(code, latitude, longitude);
//	}
//	@Transient
//	public void setGeoLocation(GeoLocation geoLocation) {
//		this.latitude=geoLocation.getLatitude();
//		this.longitude=geoLocation.getLongitude();
//	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Area(String code, String areaName, String cityName,
			double latitude,double longitude) {
		super();
		this.code = code;
		this.areaName = areaName;
		this.cityName = cityName;
		this.latitude=latitude;
		this.longitude=longitude;
//		this.setGeoLocation(geoLocation);
	}
	
}
