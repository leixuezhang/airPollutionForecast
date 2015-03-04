package com.airforecast.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.airforecast.dao.MockDaoUtil;
import com.airforecast.model.area.Area;
import com.airforecast.model.weather.Weather;

public class WeatherReport {

	public WeatherReport() {
		/*Properties props = new Properties();
		try {
			props.load(ClassLoader
					.getSystemResourceAsStream("application.properties"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		url = props.getProperty("weather.api");
		if (null == url) {
			url = "http://www.myweather2.com/developer/forecast.ashx?uac=qakRW6ydlr&output=xml&query=";
		}*/
		url = "http://www.myweather2.com/developer/forecast.ashx?uac=qakRW6ydlr&output=xml&query=";
	}

	String url;

	// @Scheduled(fixedDelayString = "10000")
	public void weatherUpdater() {
		for (Area area : MockDaoUtil.areas.values()) {
			Weather weather = getWeather(area);
			System.out.println(weather);
		}
	}

	public Weather getWeather(Area area) {
		if (area == null)
			return null;
		try {
			Weather weather = unmarshall(
					readDataFromUrlGet(url + area.getLatitude() + ","
							+ area.getLongitude()), Weather.class);
			return weather;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshall(StringReader stream, Class<T> clazz) {
		T obj;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			obj = (T) jaxbUnmarshaller.unmarshal(stream);
		} catch (JAXBException e) {
			return null;
		} finally {
		}
		return obj;
	}

	public static StringReader readDataFromUrlGet(String localURL) {
		HttpURLConnection connection = null;
		StringReader reader = null;
		try {
			URL url = new URL(localURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			StringWriter writer = new StringWriter();
			String line = "";
			while ((line = rd.readLine()) != null) {
				writer.write(line);
				System.out.println(line);
			}
			reader = new StringReader(writer.toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (null != connection) {
				connection.disconnect();
			}
		}
		return reader;
	}
}
