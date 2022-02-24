package com.sparta.weatherapiproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.weatherapiproject.ApiKeyGetter;
import com.sparta.weatherapiproject.WeatherInjector;
import com.sparta.weatherapiproject.jackson.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InjectorTest {
    private static final String TEST_JSON_PATH = "test.json";
    private static final double TEST_COORD_LON = -122.08;
    private static final double TEST_COORD_LAT = 37.39;
    private static final int TEST_WEATHER_ID = 800;
    private static final String TEST_WEATHER_MAIN = "Clear";
    private static final String TEST_WEATHER_DESCRIPTION = "clear sky";
    private static final String TEST_WEATHER_ICON = "01d";
    private static final String TEST_BASE = "stations";
    private static final double TEST_MAIN_TEMP = 282.55;
    private static final double TEST_MAIN_FEELS_LIKE = 281.66;
    private static final double TEST_MAIN_TEMP_MIN = 280.37;
    private static final double TEST_MAIN_TEMP_MAX = 284.26;
    private static final int TEST_MAIN_PRESSURE = 1023;
    private static final int TEST_MAIN_HUMIDITY = 100;
    private static final int TEST_VISIBILITY = 16093;
    private static final int TEST_WIND_DEG = 350;
    private static final double TEST_WIND_GUST = 1.9;
    private static final double TEST_WIND_SPEED = 1.5;
    private static final double TEST_RAIN_1H = 0.65;
    private static final double TEST_RAIN_3H = 1.29;
    private static final double TEST_SNOW_1H = 0.12;
    private static final double TEST_SNOW_3H = 0.28;
    private static final int TEST_CLOUDS_ALL = 1;
    private static final int TEST_DT = 1560350645;
    private static final int TEST_SYS_SUNRISE = 1560343627;
    private static final int TEST_SYS_SUNSET = 1560396563;
    private static final int TEST_TIMEZONE = -25200;
    private static final int TEST_ID = 420006353;
    private static final String TEST_NAME = "Mountain View";
    private static final int TEST_COD = 200;

    private static WeatherInjector wi;
    private static String jsonString;

    @BeforeAll
    public static void setUp() throws IOException {
        wi = new WeatherInjector();
        jsonString = getJSONString();
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the current weather data and store it in a CurrentWeatherData object.")
    public void testGetCurrentWeatherData() throws JsonProcessingException {
        CurrentWeatherData cwd = wi.getCurrentWeatherData(jsonString);
        Coord coord = cwd.getCoord();
        WeatherItem weatherItem = cwd.getWeather().get(0);
        Main main = cwd.getMain();
        Wind wind = cwd.getWind();
        Rain rain = cwd.getRain();
        Snow snow = cwd.getSnow();
        Clouds clouds = cwd.getClouds();
        Sys sys = cwd.getSys();
        Assertions.assertEquals(TEST_COORD_LON, coord.getLon());
        Assertions.assertEquals(TEST_COORD_LAT, coord.getLat());
        Assertions.assertEquals(TEST_WEATHER_ID, weatherItem.getId());
        Assertions.assertEquals(TEST_WEATHER_MAIN, weatherItem.getMain());
        Assertions.assertEquals(TEST_WEATHER_DESCRIPTION, weatherItem.getDescription());
        Assertions.assertEquals(TEST_WEATHER_ICON, weatherItem.getIcon());
        Assertions.assertEquals(TEST_BASE, cwd.getBase());
        Assertions.assertEquals(TEST_MAIN_TEMP, main.getTemp());
        Assertions.assertEquals(TEST_MAIN_FEELS_LIKE, main.getFeelsLike());
        Assertions.assertEquals(TEST_MAIN_TEMP_MIN, main.getTempMin());
        Assertions.assertEquals(TEST_MAIN_TEMP_MAX, main.getTempMax());
        Assertions.assertEquals(TEST_MAIN_PRESSURE, main.getPressure());
        Assertions.assertEquals(TEST_MAIN_HUMIDITY, main.getHumidity());
        Assertions.assertEquals(TEST_VISIBILITY, cwd.getVisibility());
        Assertions.assertEquals(TEST_WIND_DEG, wind.getDeg());
        Assertions.assertEquals(TEST_WIND_GUST, wind.getGust());
        Assertions.assertEquals(TEST_WIND_SPEED, wind.getSpeed());
        Assertions.assertEquals(TEST_RAIN_1H, rain.getJsonMember1h());
        Assertions.assertEquals(TEST_RAIN_3H, rain.getJsonMember3h());
        Assertions.assertEquals(TEST_SNOW_1H, snow.getJsonMember1h());
        Assertions.assertEquals(TEST_SNOW_3H, snow.getJsonMember3h());
        Assertions.assertEquals(TEST_CLOUDS_ALL, clouds.getAll());
        Assertions.assertEquals(TEST_DT, cwd.getDt());
        Assertions.assertEquals(TEST_SYS_SUNRISE, sys.getSunrise());
        Assertions.assertEquals(TEST_SYS_SUNSET, sys.getSunset());
        Assertions.assertEquals(TEST_TIMEZONE, cwd.getTimezone());
        Assertions.assertEquals(TEST_ID, cwd.getId());
        Assertions.assertEquals(TEST_NAME, cwd.getName());
        Assertions.assertEquals(TEST_COD, cwd.getCod());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the coordinates data and store it in a Coord object.")
    public void testgetCoordinates() throws JsonProcessingException {
        Coord coord = wi.getCoordinates(jsonString);
        Assertions.assertEquals(TEST_COORD_LON, coord.getLon());
        Assertions.assertEquals(TEST_COORD_LAT, coord.getLat());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the Weather data and store it in a WeatherItem object.")
    public void testGetWeatherItem() throws JsonProcessingException {
        WeatherItem weatherItem = wi.getWeatherList(jsonString).get(0);
        Assertions.assertEquals(TEST_WEATHER_ID, weatherItem.getId());
        Assertions.assertEquals(TEST_WEATHER_MAIN, weatherItem.getMain());
        Assertions.assertEquals(TEST_WEATHER_DESCRIPTION, weatherItem.getDescription());
        Assertions.assertEquals(TEST_WEATHER_ICON, weatherItem.getIcon());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the Main data and store it in a Main object.")
    public void testGetMain() throws JsonProcessingException {
        Main main = wi.getMain(jsonString);
        Assertions.assertEquals(TEST_MAIN_TEMP, main.getTemp());
        Assertions.assertEquals(TEST_MAIN_FEELS_LIKE, main.getFeelsLike());
        Assertions.assertEquals(TEST_MAIN_TEMP_MIN, main.getTempMin());
        Assertions.assertEquals(TEST_MAIN_TEMP_MAX, main.getTempMax());
        Assertions.assertEquals(TEST_MAIN_PRESSURE, main.getPressure());
        Assertions.assertEquals(TEST_MAIN_HUMIDITY, main.getHumidity());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the wind data and store it in a Wind object.")
    public void testGetWind() throws JsonProcessingException {
        Wind wind = wi.getWind(jsonString);
        Assertions.assertEquals(TEST_WIND_DEG, wind.getDeg());
        Assertions.assertEquals(TEST_WIND_GUST, wind.getGust());
        Assertions.assertEquals(TEST_WIND_SPEED, wind.getSpeed());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the rain data and store it in a Rain object.")
    public void testGetRain() throws JsonProcessingException {
        Rain rain = wi.getRain(jsonString);
        Assertions.assertEquals(TEST_RAIN_1H, rain.getJsonMember1h());
        Assertions.assertEquals(TEST_RAIN_3H, rain.getJsonMember3h());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the snow data and store it in a Snow object.")
    public void testGetSnow() throws JsonProcessingException {
        Snow snow = wi.getSnow(jsonString);
        Assertions.assertEquals(TEST_SNOW_1H, snow.getJsonMember1h());
        Assertions.assertEquals(TEST_SNOW_3H, snow.getJsonMember3h());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the clouds data and store it in a Clouds object.")
    public void testGetClouds() throws JsonProcessingException {
        Clouds clouds = wi.getClouds(jsonString);
        Assertions.assertEquals(TEST_CLOUDS_ALL, clouds.getAll());
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the sun cycle data and store it in a Sys object.")
    public void testGetSunCycle() throws JsonProcessingException {
        Sys sys = wi.getSunCycle(jsonString);
        Assertions.assertEquals(TEST_SYS_SUNRISE, sys.getSunrise());
        Assertions.assertEquals(TEST_SYS_SUNSET, sys.getSunset());
    }

    private static String getJSONString() throws IOException {
        return new String(Files.readAllBytes(Paths.get(TEST_JSON_PATH)));
    }

}
