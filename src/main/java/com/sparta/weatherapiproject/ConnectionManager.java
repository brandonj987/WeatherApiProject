package com.sparta.weatherapiproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;

public class ConnectionManager {

    public static CurrentWeatherData currentWeatherDataConnection(String city, String apiKey){
        CurrentWeatherData currentWeatherData = new CurrentWeatherData();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            currentWeatherData = objectMapper.readValue(
                    new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey),
                    CurrentWeatherData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentWeatherData;
    }


}
