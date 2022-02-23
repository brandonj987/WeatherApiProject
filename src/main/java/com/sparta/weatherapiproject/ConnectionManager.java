package com.sparta.weatherapiproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapiproject.jackson.WeatherReport;

import java.io.IOException;
import java.net.URL;

public class ConnectionManager {

    public static WeatherReport weatherReportConnection(String city, String apiKey){
        WeatherReport weatherReport = new WeatherReport();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weatherReport = objectMapper.readValue(
                    new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey),
                    WeatherReport.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherReport;
    }

}
