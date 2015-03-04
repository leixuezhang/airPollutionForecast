/**
 * 
 */
package com.airforecast.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airforecast.model.NormalizedHeatmap;
import com.airforecast.model.area.Area;
import com.airforecast.service.AirProcessDataImlp;
import com.airforecast.service.IProcessData;

/**
 * Delegates all request from the app
 * 
 * @author Aruna
 * 
 */
@RestController
@RequestMapping("/airForecastController")
public class AirForecastController {

	@Autowired
	private IProcessData airProcessDataImpl;
	
	public AirForecastController(){
		if(airProcessDataImpl==null) airProcessDataImpl=new AirProcessDataImlp();
	}

	@RequestMapping(value = "/live", method = RequestMethod.GET, produces = "application/json")
	public NormalizedHeatmap getTempMapLive(@RequestParam("lat") String latitude,
			@RequestParam("lon") String longitude) {
		return airProcessDataImpl.getForcastDetail(latitude, longitude, true);
	}

	@RequestMapping(value = "/forcast", method = RequestMethod.GET, produces = "application/json")
	public NormalizedHeatmap getTempMapForcast(@RequestParam("lat") String latitude,
			@RequestParam("lon") String longitude) {
		return airProcessDataImpl.getForcastDetail(latitude, longitude, false);
	}

	@RequestMapping(value = "/alllive", method = RequestMethod.GET, produces = "application/json")
	public List<NormalizedHeatmap> getAllLive() {
		List<NormalizedHeatmap> maps = new ArrayList<NormalizedHeatmap>();
		for (String loc : airProcessDataImpl.getAllLocation()) {
			String locs[] = loc.split(",");
			maps.add(airProcessDataImpl
					.getForcastDetail(locs[0], locs[1], true));
		}
		return maps;
	}

	@RequestMapping(value = "/allforcast", method = RequestMethod.GET, produces = "application/json")
	public List<NormalizedHeatmap> getAllForecast() {
		List<NormalizedHeatmap> maps = new ArrayList<NormalizedHeatmap>();
		for (String loc : airProcessDataImpl.getAllLocation()) {
			String locs[] = loc.split(",");
			maps.add(airProcessDataImpl.getForcastDetail(locs[0], locs[1],
					false));
		}
		return maps;
	}

	@RequestMapping("/getAllLocation")
	public List<String> getAllLocation() {
		return airProcessDataImpl.getAllLocation();
	}

	@RequestMapping("/getAllArea")
	public List<Area> getAllArea() {
		return airProcessDataImpl.getALLArea();
	}

}
