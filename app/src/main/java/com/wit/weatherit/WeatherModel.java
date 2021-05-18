package com.wit.weatherit;
public class WeatherModel {
    private String day, time, icon, temp, tempMin, tempMax, description;
    public WeatherModel() {
    }
    public WeatherModel(String day, String time, String icon, String temp, String tempMin, String tempMax, String description) {
        this.day = day;
        this.time = time;
        this.icon = icon;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.description = description;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getTemp() {
        return temp+"ºC";
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public String getTempMin() {
        return tempMin+"ºC";
    }
    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }
    public String getTempMax() {
        return tempMax+"ºC";
    }
    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
