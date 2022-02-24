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
    private static final String TEST_JSON_PATH = "../../../test.json";
    private static final double TEST_COORD_LON = -122.08;
    private static final double TEST_COORD_LAT = 37.39;
    private static final int TEST_WEATHER_ID = 800;
    private static final String TEST_WEATHER_MAIN = "Clear";
    private static final String TEST_WEATHER_DESCRIPTION = "clear sky",
    private static final String TEST_WEATHER_ICON = "01d";
    private static final double TEST_MAIN_TEMP = 282.55;
    private static final double TEST_MAIN_FEELS_LIKE = 281.66;
    private static final double TEST_MAIN_TEMP_MIN = 280.37;
    private static final double TEST_MAIN_TEMP_MAX = 284.26;
    private static final int TEST_MAIN_PRESSURE = 1023;
    private static final int TEST_MAIN_HUMIDITY = 100;
    private static final int TEST_WIND_DEG = 350;
    private static final double TEST_WIND_GUST = 1.9;
    private static final double TEST_WIND_SPEED = 1.5;
    private static final int TEST_SYS_SUNRISE = 1560343627;
    private static final int TEST_SYS_SUNSET = 1560396563;
    private static final int TEST_CLOUDS_ALL = 1;
    private static final double TEST_RAIN_1H = 0.65;
    private static final double TEST_RAIN_3H = 1.29;
    private static final double TEST_SNOW_1H = 0.12;
    private static final double TEST_SNOW_3H = 0.28;

    private static WeatherInjector wi;
    private static String jsonString;

    @BeforeAll
    public static void setUp() throws IOException {
        wi = new WeatherInjector();
        jsonString = getJSONString();
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the coordinates data and store it in a Coord object.")
    public void testgetCoordinates() throws JsonProcessingException {
        Coord coord = wi.getCoordinates(jsonString);
        Assertions.assertEquals(coord.getLon(), TEST_COORD_LON);
        Assertions.assertEquals(coord.getLat(), TEST_COORD_LAT);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the Weather data and store it in a WeatherItem object.")
    public void testGetWeatherItem() throws JsonProcessingException {
        WeatherItem weatherItem = wi.getWeatherList(jsonString).get(0);
        Assertions.assertEquals(weatherItem.getId(), TEST_WEATHER_ID);
        Assertions.assertEquals(weatherItem.getMain(), TEST_WEATHER_MAIN);
        Assertions.assertEquals(weatherItem.getDescription(), TEST_WEATHER_DESCRIPTION);
        Assertions.assertEquals(weatherItem.getIcon(), TEST_WEATHER_ICON);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the Main data and store it in a Main object.")
    public void testGetMain() throws JsonProcessingException {
        Main main = wi.getMain(jsonString);
        Assertions.assertEquals(main.getTemp(), TEST_MAIN_TEMP);
        Assertions.assertEquals(main.getFeelsLike(), TEST_MAIN_FEELS_LIKE);
        Assertions.assertEquals(main.getTempMin(), TEST_MAIN_TEMP_MIN);
        Assertions.assertEquals(main.getTempMax(), TEST_MAIN_TEMP_MAX);
        Assertions.assertEquals(main.getPressure(), TEST_MAIN_PRESSURE);
        Assertions.assertEquals(main.getHumidity(), TEST_MAIN_HUMIDITY);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the wind data and store it in a Wind object.")
    public void testGetWind() throws JsonProcessingException {
        Wind wind = wi.getWind(jsonString);
        Assertions.assertEquals(wind.getDeg(), TEST_WIND_DEG);
        Assertions.assertEquals(wind.getGust(), TEST_WIND_GUST);
        Assertions.assertEquals(wind.getSpeed(), TEST_WIND_SPEED);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the rain data and store it in a Rain object.")
    public void testGetRain() throws JsonProcessingException {
        Rain rain = wi.getRain(jsonString);
        Assertions.assertEquals(rain.get1h(), TEST_RAIN_1H);
        Assertions.assertEquals(rain.get3h(), TEST_RAIN_3H);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the snow data and store it in a Snow object.")
    public void testGetSnow() throws JsonProcessingException {
        Snow snow = wi.getSnow(jsonString);
        Assertions.assertEquals(snow.get1h(), TEST_SNOW_1H);
        Assertions.assertEquals(snow.get3h(), TEST_SNOW_3H);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the clouds data and store it in a Clouds object.")
    public void testGetClouds() throws JsonProcessingException {
        Clouds clouds = wi.getClouds(jsonString);
        Assertions.assertEquals(clouds.getAll(), TEST_CLOUDS_ALL);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the sun cycle data and store it in a Sys object.")
    public void testGetSunCycle() throws JsonProcessingException {
        Sys sys = wi.getSunCycle(jsonString);
        Assertions.assertEquals(sys.getSunrise(), TEST_SYS_SUNRISE);
        Assertions.assertEquals(sys.getSunset(), TEST_SYS_SUNSET);
    }

    private static String getJSONString() throws IOException {
        return new String(Files.readAllBytes(Paths.get(TEST_JSON_PATH)));
    }

}
