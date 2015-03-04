package com.airforecast.model.weather;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "day")  
public class Day
{
private String weather_code;

private Wind wind;

private String cloudcover;

private String humidity;

private String visibility_km;

private String precip_mm;

private String pressure_mb;

private String weather_text;

public String getWeather_code ()
{
return weather_code;
}

public void setWeather_code (String weather_code)
{
this.weather_code = weather_code;
}

public Wind getWind ()
{
return wind;
}

public void setWind (Wind wind)
{
this.wind = wind;
}

public String getCloudcover ()
{
return cloudcover;
}

public void setCloudcover (String cloudcover)
{
this.cloudcover = cloudcover;
}

public String getHumidity ()
{
return humidity;
}

public void setHumidity (String humidity)
{
this.humidity = humidity;
}

public String getVisibility_km ()
{
return visibility_km;
}

public void setVisibility_km (String visibility_km)
{
this.visibility_km = visibility_km;
}

public String getPrecip_mm ()
{
return precip_mm;
}

public void setPrecip_mm (String precip_mm)
{
this.precip_mm = precip_mm;
}

public String getPressure_mb ()
{
return pressure_mb;
}

public void setPressure_mb (String pressure_mb)
{
this.pressure_mb = pressure_mb;
}

public String getWeather_text ()
{
return weather_text;
}

public void setWeather_text (String weather_text)
{
this.weather_text = weather_text;
}
}
	
	
