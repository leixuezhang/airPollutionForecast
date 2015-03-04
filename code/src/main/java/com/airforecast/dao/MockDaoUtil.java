package com.airforecast.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.airforecast.model.HeatMap;
import com.airforecast.model.area.Area;
import com.airforecast.model.area.GeoLocation;

@Component
public class MockDaoUtil {
	static Random random=new Random();
	public static Map<String,Area> areas=new HashMap<String,Area>();
	
	static {
		areas.put("GANP", new Area("GANP","Ganapathy","Coimbatore",11.3000,77.1000));
		areas.put("GAND", new Area("GAND","Gandhipuram","Coimbatore",11.2000,77.2000) );
		areas.put("PEEL", new Area("PEEL","Peelamedu","Coimbatore",11.1000,77.0100) );
		areas.put("SIGNR", new Area("SIGNR","Singanallur","Coimbatore",11.00282460,77.030538999999980000) );
		areas.put("UKDM", new Area("UKDM","Ukkadam","Coimbatore",10.990213,76.962866) );
	}
	
	public List<HeatMap> getAllHeatMap(){
		List<HeatMap> heatMap=new ArrayList<HeatMap>();
		for (Area area : areas.values()) {
			heatMap.add(new HeatMap(area,random.nextInt(8) ));
		}
		return heatMap;
	}
	
	public HeatMap getHeatMap(String areaCode){
		if(areas.containsKey(areaCode))
			return new HeatMap(areas.get(areaCode),random.nextInt(8) );
		return null;
	}
	
	public HeatMap getHeatMap(double lat,double lng){
			return new HeatMap(getArea(lat,lng),random.nextInt(8) );
	}
	
	public Area getArea(String areaCode){
		if(areas.containsKey(areaCode))
			return areas.get(areaCode);
		return null;
	}
	
	public Area getArea(double lat,double lng){
		for (Area area : areas.values()) {
			if(area.getLongitude()==lng && area.getLatitude()==lat)
			return area;
		}
		return null;
	}
	
}
