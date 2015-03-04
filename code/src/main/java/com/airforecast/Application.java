package com.airforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.airforecast.dao.DaoUtil;
import com.airforecast.model.area.Area;
import com.airforecast.model.weather.LiveWeather;
import com.airforecast.model.weather.Weather;
import com.airforecast.service.WeatherReport;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
// @EnableScheduling
public class Application {

	public static void main(String[] args) {
		System.out.println("Application Started...");
		// HeatMap heatMap = new AirProcessDataImlp().getForcastDetail(11.1000,
		// 77.0100, true);
		SpringApplication.run(Application.class, args);
		/*Area area = new DaoUtil().getArea("11.0028246","77.03053899999998");
		Weather weather = new WeatherReport().getWeather(area);
		LiveWeather liveWeather = weather.getCurrent_weather();*/
	}
}
