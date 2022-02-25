package com.sparta.weatherapiproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapiproject.jackson.*;
import io.cucumber.java.it.Ma;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class WeatherInjector {


    public CurrentWeatherData getCurrentWeatherData(String jsonString) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonString, CurrentWeatherData.class);

    }
    public CurrentWeatherData getCurrentWeatherData(double lat, double lon, String apiKey) throws IOException {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s", lat, lon, apiKey);
        return new ObjectMapper().readValue(new URL(url), CurrentWeatherData.class);
    }
//
//    public Coord getCoordinates(String jsonString) throws JsonProcessingException{
//        return new ObjectMapper().readValue(jsonString, Coord.class);
//    }
//    public List<WeatherItem> getWeatherList(String jsonString) throws JsonProcessingException {
//        return new ObjectMapper().readValue(jsonString, new TypeReference<List<WeatherItem>>(){});
//    }
//
//    public WeatherItem getWeatherItem(String jsonString) throws JsonProcessingException{
//        return new ObjectMapper().readValue(jsonString, WeatherItem.class);
//    }
//
//    public Wind getWind(String jsonString) throws JsonProcessingException {
//        return new ObjectMapper().readValue(jsonString, Wind.class);
//    }
//
//    public Clouds getClouds(String jsonString) throws JsonProcessingException{
//        return new ObjectMapper().readValue(jsonString, Clouds.class);
//    }
//
//    public Rain getRain(String jsonString) throws JsonProcessingException{
//        return new ObjectMapper().readValue(jsonString, Rain.class);
//    }
//
//    public Snow getSnow(String jsonString) throws JsonProcessingException{
//        return new ObjectMapper().readValue(jsonString, Snow.class);
//    }
//
//    public Sys getSunCycle(String jsonString) throws  JsonProcessingException{
//        return new ObjectMapper().readValue(jsonString, Sys.class);
//    }
//
//
//    public Main getMain(String jsonString) throws JsonProcessingException {
//        return new ObjectMapper().readValue(jsonString, Main.class);
//    }



}
