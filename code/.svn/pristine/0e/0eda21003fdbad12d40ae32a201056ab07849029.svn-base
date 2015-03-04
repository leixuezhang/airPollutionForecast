package com.airforecast.model;

import com.airforecast.model.area.Area;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HeatMap")  
public class HeatMap {
	private Area area;
	private int heatCount;
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public int getHeatCount() {
		return heatCount;
	}
	public void setHeatCount(int heatCount) {
		this.heatCount = heatCount;
	}
	public HeatMap(Area area, int heatCount) {
		super();
		this.area = area;
		this.heatCount = heatCount;
	}
	
}
