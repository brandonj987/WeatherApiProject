import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.weatherapiproject.ApiKeyGetter;
import com.sparta.weatherapiproject.WeatherInjector;
import com.sparta.weatherapiproject.ConnectionManager;
import com.sparta.weatherapiproject.jackson.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InjectorTest {
    private static final String TEST_URL = "";
    private static final double TEST_COORD_LON = 0;
    private static final double TEST_COORD_LAT = 0;
    private static final int TEST_WIND_DEG = 0;
    private static final double TEST_WIND_GUST = 0;
    private static final double TEST_WIND_SPEED = 0;
    private static final int TEST_SYS_SUNRISE = 0;
    private static final int TEST_SYS_SUNSET = 0;

    private static WeatherInjector wi;
    private static String apiKey;
    private static String jsonString;

    @BeforeAll
    public static void setUp() {
        wi = new WeatherInjector();
        apiKey = ApiKeyGetter.getApiKey();
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
            "the wind data and store it in a Wind object.")
    public void testGetWind() throws JsonProcessingException {
        Wind wind = wi.getWind(jsonString);
        Assertions.assertEquals(wind.getDeg(), TEST_WIND_DEG);
        Assertions.assertEquals(wind.getGust(), TEST_WIND_GUST);
        Assertions.assertEquals(wind.getSpeed(), TEST_WIND_SPEED);
    }

    @Test
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the sun cycle data and store it in a Sys object.")
    public void testGetSunCycle() throws JsonProcessingException {
        Sys sys = wi.getSunCycle(jsonString);
        Assertions.assertEquals(sys.getSunrise(), TEST_SYS_SUNRISE);
        Assertions.assertEquals(sys.getSunset(), TEST_SYS_SUNSET);
    }

    private static String getJSONString() {
        String s = ConnectionManager.httpConnection(TEST_URL, apiKey);
        if(s != null) return s; // else
        ConnectionManager cm = Mockito.mock(ConnectionManager.class);
        Mockito.when(cm.httpConnection(TEST_URL, apiKey)).thenReturn("test");
        return cm.httpConnection(TEST_URL, apiKey);
    }

}
