package com.sparta.weatherapiproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.weatherapiproject.jackson.CurrentWeatherData;
import com.sparta.weatherapiproject.jackson.WeatherItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExampleTest {

    static CurrentWeatherData currentWeatherData;
    static String dtoString;
    WeatherInjector weatherInjector;

    @BeforeAll
    static void setUp() throws JsonProcessingException {
        String url = UrlGenerator.getURL("London", ApiKeyGetter.getApiKey());
        dtoString = ConnectionManager.httpConnection(url);
    }

    @Test
    @DisplayName("Coord Lon is exist test")
    public void coordLonIsExistTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        assertThat(weatherInjector.getCurrentWeatherData(dtoString).getCoord().toString(),allOf(containsString("Coord"),containsString("lon")));
    }
    @Test
    @DisplayName("Coord Lat is exist test")
    public void coordLatIsExistTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        assertThat(weatherInjector.getCurrentWeatherData(dtoString).getCoord().toString(),allOf(containsString("Coord"),containsString("lat")));
    }

    @Test
    @DisplayName("Coord Lat is valid Test")
    public void coordLatValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double weatherLat = weatherInjector.getCurrentWeatherData(dtoString).getCoord().getLat();
        Boolean isValid = true;
        if(weatherLat > 90 || weatherLat < -90){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Coord lon is valid Test")
    public void coordLanValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double weatherLon = weatherInjector.getCurrentWeatherData(dtoString).getCoord().getLat();
        Boolean isValid = true;
        if(weatherLon > 90 || weatherLon < -90){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Main temp is valid test")
    public void mainTempIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double temp = weatherInjector.getCurrentWeatherData(dtoString).getMain().getTemp();
        Boolean isValid = true;
        if(temp > 318.15 || temp < 248.15){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }


    @Test
    @DisplayName("Main feel like temp is valid test")
    public void mainFeelLikeTempIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double feelsLikeTemp = weatherInjector.getCurrentWeatherData(dtoString).getMain().getFeelsLike();
        Boolean isValid = true;
        if(feelsLikeTemp > 318.15 || feelsLikeTemp < 248.15){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }
    @Test
    @DisplayName("Main max temp is valid test")
    public void mainMaxTempIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double maxTemp = weatherInjector.getCurrentWeatherData(dtoString).getMain().getTempMax();
        Boolean isValid = true;
        if(maxTemp > 318.15 || maxTemp < 248.15){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }
    @Test
    @DisplayName("Main min temp is valid test")
    public void mainMinTempIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double minTemp = weatherInjector.getCurrentWeatherData(dtoString).getMain().getTempMin();
        Boolean isValid = true;
        if(minTemp > 318.15 || minTemp < 248.15){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Main humidity is valid test")
    public void mainHumidityTempIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double humidity = weatherInjector.getCurrentWeatherData(dtoString).getMain().getHumidity();
        Boolean isValid = true;
        System.out.println(humidity);
        if(humidity < 0 || humidity > 100){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Main visibility is valid test")
    public void mainVisibilityTempIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double visibility = weatherInjector.getCurrentWeatherData(dtoString).getVisibility();
        Boolean isValid = true;
        if(visibility < 0){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Wind speed is valid test")
    public void windSpeedIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double windspeed = weatherInjector.getCurrentWeatherData(dtoString).getWind().getSpeed();
        Boolean isValid = true;
        if(windspeed < 0){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Wind deg is valid test")
    public void windDegIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        double windDeg = weatherInjector.getCurrentWeatherData(dtoString).getWind().getDeg();
        Boolean isValid = true;
        if(windDeg < 0 || windDeg > 360){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Sys country is valid test")
    public void sysCountryIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        String sysCountry = weatherInjector.getCurrentWeatherData(dtoString).getSys().getCountry();
        Boolean isValid = true;
        if(sysCountry == null){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Sys sunrise is valid test")
    public void sysSunriseIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        int sysSunrise = weatherInjector.getCurrentWeatherData(dtoString).getSys().getSunrise();
        Boolean isValid = true;
        if(sysSunrise < 1645685813){                //current ux time (24/2/2022)
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Sys sunset is valid test")
    public void sysSunsetIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        int sysSunrise = weatherInjector.getCurrentWeatherData(dtoString).getSys().getSunset();
        Boolean isValid = true;
        if(sysSunrise < 1645723857){                //current ux time (24/2/2022)
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Timezone is valid test")
    public void timezoneIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        int  timezone = weatherInjector.getCurrentWeatherData(dtoString).getTimezone();
        Boolean isValid = true;
        if(timezone < -43200 || timezone > 50400){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Name is valid test")
    public void nameIsValidTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();
        String name = weatherInjector.getCurrentWeatherData(dtoString).getName();
        Boolean isValid = true;
        if(name == null){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Weather main weather test")
    public void weatherMainWeatherTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();

       List<WeatherItem> weatherItemList = weatherInjector.getCurrentWeatherData(dtoString).getWeather();
        Boolean isValid = true;
        if(  weatherItemList.get(0).getMain() == null){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("Weather description test")
    public void weatherDescriptionTest() throws JsonProcessingException {
        weatherInjector = new WeatherInjector();

        List<WeatherItem> weatherItemList = weatherInjector.getCurrentWeatherData(dtoString).getWeather();
        Boolean isValid = true;
        if(  weatherItemList.get(0).getDescription() == null){
            isValid = false;
        }
        Assertions.assertTrue(isValid);
    }

}


