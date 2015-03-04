package com.airforecast.model.weather;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forecast")  
public class Forecast
{
private String temp_unit;

private String day_max_temp;

private String night_min_temp;

private Night night;

private Day day;

private String date;

public String getTemp_unit ()
{
return temp_unit;
}

public void setTemp_unit (String temp_unit)
{
this.temp_unit = temp_unit;
}

public String getDay_max_temp ()
{
return day_max_temp;
}

public void setDay_max_temp (String day_max_temp)
{
this.day_max_temp = day_max_temp;
}

public String getNight_min_temp ()
{
return night_min_temp;
}

public void setNight_min_temp (String night_min_temp)
{
this.night_min_temp = night_min_temp;
}

public Night getNight ()
{
return night;
}

public void setNight (Night night)
{
this.night = night;
}

public Day getDay ()
{
return day;
}

public void setDay (Day day)
{
this.day = day;
}

public String getDate ()
{
return date;
}

public void setDate (String date)
{
this.date = date;
}
}