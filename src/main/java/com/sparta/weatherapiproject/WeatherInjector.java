package com.sparta.weatherapiproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.it.Ma;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WeatherInjector {

    public CurrentWeatherData getCurrentWeatherData(double lat, double lon, String apiKey) throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s", lat, lon, apiKey);
        CurrentWeatherData currentWeatherData = objMap.readValue(new URL(url), CurrentWeatherData.class);
        return currentWeatherData;
    }

    public Coord getCoordinates(String jsonString) throws JsonProcessingException{
        ObjectMapper objMap = new ObjectMapper();
        Coord coord = objMap.readValue(jsonString, Coord.class);
        return coord;
    }
    public List<WeatherItem> getWeatherList(String jsonString) throws JsonProcessingException {
        ObjectMapper objMap = new ObjectMapper();
        List<WeatherItem> weatherItemList = objMap.readValue(jsonString, new TypeReference<List<WeatherItem>>(){});
        return weatherItemList;
    }

    public Wind getWind(String jsonString) throws JsonProcessingException {
        ObjectMapper objMap = new ObjectMapper();
        Wind wind = objMap.readValue(jsonString, Wind.class);
        return wind;
    }


    public Clouds getClouds(String jsonString) throws  JsonProcessingException{
        ObjectMapper objMap = new ObjectMapper();
        Clouds clouds = objMap.readValue(jsonString, Clouds.class);
        return clouds;
    }

    public Sys getSunCycle(String jsonString) throws  JsonProcessingException{
        ObjectMapper objMap = new ObjectMapper();
        Sys sunCycle = objMap.readValue(jsonString, Sys.class);
        return sunCycle;
    }



}
