package com.wit.weatherit;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class forecastData {

    private String day, time, icon, temp, tempMin, tempMax, description;
    private int mCondition;

    private List<WeatherModel> weatherList = new ArrayList<>();

    public static forecastData fromJson(JSONObject jsonObject)
    {
        try
        {
            int lenght = jsonObject.getJSONArray("list").length();
            forecastData forecastD=new forecastData();
            for (int i = 0; i < lenght; i++){

                // Day of Week
                int timestamp = jsonObject.getJSONArray("list").getJSONObject(i).getInt("dt");
                Date date= new Date((long)timestamp*1000);
                forecastD.day= new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
                // Time
                forecastD.time= new SimpleDateFormat("HH:mm").format(date);
                // Condition
                forecastD.mCondition=jsonObject.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getInt("id");
                // Description
                forecastD.description=jsonObject.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main");
                // Icon
                forecastD.icon=updateWeatherIcon(forecastD.mCondition);
                // Temperature
                double tempResult=jsonObject.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp")-273.15;
                int roundedValue=(int) Math.rint(tempResult);
                forecastD.temp= Integer.toString(roundedValue);
                // Temperature Minimum
                double tempMinResult=jsonObject.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp_min")-273.15;
                int roundedMinValue=(int) Math.rint(tempMinResult);
                forecastD.tempMin= Integer.toString(roundedMinValue);
                // Temperature Maximum
                double tempMaxResult=jsonObject.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp_max")-273.15;
                int roundedMaxValue=(int) Math.rint(tempMaxResult);
                forecastD.tempMax= Integer.toString(roundedMaxValue);

                WeatherModel weather = new WeatherModel(forecastD.day, forecastD.time
                        , forecastD.icon, forecastD.temp, forecastD.tempMin, forecastD.tempMax, forecastD.description);
                forecastD.weatherList.add(weather);
            }
            return forecastD;
        }
         catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<300)
        {
            return "thunderstrom1";
        }
        else if(condition>=300 && condition<500)
        {
            return "lightrain";
        }
        else if(condition>=500 && condition<600)
        {
            return "shower";
        }
       else  if(condition>=600 && condition<700)
        {
            return "snow2";
        }
        else if(condition>=700 && condition<=701)
        {
            return "mist";
        }
        else if(condition>701 && condition<741)
        {
            return "overcast";
        }
        else if(condition==741)
        {
            return "fog";
        }
        else if(condition>=751 && condition<=771)
        {
            return "overcast";
        }
        else if(condition>771 && condition<800)
        {
            return "tornado";
        }
       else if(condition==800)
        {
            return "sunny";
        }
        else if(condition>=801 && condition<=804)
        {
            return "cloudy";
        }
       else  if(condition>=900 && condition<=902)
        {
            return "thunderstrom1";
        }
        if(condition==903)
        {
            return "snow1";
        }
        if(condition==904)
        {
            return "sunny";
        }
        if(condition>=905 && condition<=1000)
        {
            return "thunderstrom2";
        }
        return "finding";
    }

    public String getDay() { return day;}

    public String getTime() { return time;}

    public String getTemp() {
        return temp+"ºC";
    }

    public String getTempMin() {
        return tempMin+"ºC";
    }

    public String getTempMax() {
        return tempMax+"ºC";
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public List<WeatherModel> getForecast() {
        return weatherList;
    }
}
