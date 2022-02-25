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

}
