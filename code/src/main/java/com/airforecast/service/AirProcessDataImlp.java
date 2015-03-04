/**
 * 
 */
package com.airforecast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.airforecast.dao.DaoUtil;
import com.airforecast.model.NormalizedHeatmap;
import com.airforecast.model.area.Area;
import com.airforecast.model.weather.Forecast;
import com.airforecast.model.weather.LiveWeather;
import com.airforecast.model.weather.Weather;
import com.airforecast.util.WindDirectionENum;

/**
 * @author Aruna
 * 
 */
@Component
public class AirProcessDataImlp implements IProcessData {

	private static DaoUtil daoUtil;

	/**
	 * @return the daoUtil
	 */
	public static DaoUtil getDaoUtil() {
		if (null == daoUtil) {
			daoUtil = new DaoUtil();
		}
		return daoUtil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.airforecast.service.IProcessData#processData(java.util.List)
	 */
	@Override
	public List<NormalizedHeatmap> getAllForcastDetail(boolean isLive) {
		return null;
	}

	@Override
	public NormalizedHeatmap getForcastDetail(String latitude,
			String longitude, boolean isLive) {
		NormalizedHeatmap heatMap = null;
		Area area = getDaoUtil().getArea(latitude, longitude);
		Weather weather = new WeatherReport().getWeather(area);
		System.out.println("Area:" + area + " -- Weather : " + weather);
		LiveWeather liveWeather = weather.getCurrent_weather();
		double livePressure = getDouble(liveWeather.getPressure());
		if (isLive) {
			double liveTemp = getDouble(liveWeather.getTemp());
			double liveSpeed = getDouble(liveWeather.getWind().getSpeed());
			double liveWindDirection = WindDirectionENum.valueOf(
					liveWeather.getWind().getDir()).getValue();
			double livePM = -82.0703 * liveTemp - 80.5704 * livePressure
					- 0.76381 * liveWindDirection - 2.03456 * liveSpeed
					+ 64531.68;
			double liveSO2 = 2.397 * liveTemp - 1.1481 * livePressure + 0.016
					* liveWindDirection + 1.173 * liveSpeed + 831.5413;
			double liveNOX = 5.728 * liveTemp + 3.2582 * livePressure - 0.0636
					* liveWindDirection + 2.1923 * liveWindDirection + 2.192
					* liveSpeed - 2601.85;
			int divideCount = getDivideCount(livePM, liveSO2, liveNOX);
			String liveHitCount = getAbsoluteHeatMapValue((int) (livePM
					+ liveSO2 + liveNOX)
					/ divideCount);
			heatMap = new NormalizedHeatmap(latitude, longitude, liveHitCount);
		} else {
			// calculation for forcast data
			Forecast forecast = weather.getFirstForecast();
			double forecastTemp = getDouble(forecast.getDay_max_temp());
			double forecastWindDirection = WindDirectionENum.valueOf(
					forecast.getDay().getWind().getDir()).getValue();
			double forecastSpeed = getDouble(forecast.getDay().getWind()
					.getSpeed());
			double foreCastPM = -82.0703 * forecastTemp - 80.5704
					* livePressure - 0.76381 * forecastWindDirection - 2.03456
					* forecastSpeed + 64531.68;
			double forecastSO2 = 2.397 * forecastTemp - 1.1481 * livePressure
					+ 0.016 * forecastWindDirection + 1.173 * forecastSpeed
					+ 831.5413;
			double forecastNOX = 5.728 * forecastTemp + 3.2582 * livePressure
					- 0.0636 * forecastWindDirection + 2.1923
					* forecastWindDirection + 2.192 * forecastSpeed - 2601.85;
			int forecastDIvCount = getDivideCount(foreCastPM, forecastSO2,
					forecastNOX);
			String forecastHeatCount = getAbsoluteHeatMapValue((int) (foreCastPM
					+ forecastSO2 + forecastNOX)
					/ forecastDIvCount);
			heatMap = new NormalizedHeatmap(latitude, longitude,
					forecastHeatCount);
		}
		return heatMap;
	}

	private double getDouble(String string) {
		double value = 0;
		try {
			value = Double.parseDouble(string);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return value;
	}

	private int getDivideCount(double pm, double so2, double nox) {
		int divideCount = 3;
		if (pm == 0) {
			--divideCount;
		}
		if (so2 == 0) {
			--divideCount;
		}
		if (nox == 0) {
			--divideCount;
		}
		if (divideCount == 0) {
			divideCount = 1;
		}
		return divideCount;
	}

	private String getAbsoluteHeatMapValue(int heatMapValue) {
		double normalHeatMapValue = heatMapValue / 10000.0;
		normalHeatMapValue += Math.random();
		if(normalHeatMapValue > 1){
			normalHeatMapValue = 1 - normalHeatMapValue;
		}
		return String.valueOf(Math.abs(normalHeatMapValue));
	}

	@Override
	public List<String> getAllLocation() {
		return getDaoUtil().getAreaGeoLocation();
	}

	@Override
	public List<Area> getALLArea() {
		return new ArrayList<Area>(getDaoUtil().getArea());
	}

}
