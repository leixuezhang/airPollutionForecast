package com.airforecast.model.area;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "geoLocation")  
public class GeoLocation {
	@Id
	private String id;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return latitude+","+longitude;
	}
	public GeoLocation(String id,double latitude, double longitude) {
		super();
		this.id =id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
