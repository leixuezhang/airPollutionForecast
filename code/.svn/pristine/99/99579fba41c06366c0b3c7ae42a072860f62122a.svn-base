/**
 * 
 */
package com.airforecast.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.airforecast.model.NormalizedHeatmap;
import com.airforecast.model.area.Area;

/**
 * Data Anlyser
 * 
 * @author Aruna
 * 
 */
@Component
public interface IProcessData {

	List<NormalizedHeatmap> getAllForcastDetail(boolean isLive);

	NormalizedHeatmap getForcastDetail(String latitude, String longitude , boolean isLive);

	List<String> getAllLocation();
	
	List<Area> getALLArea();
}
