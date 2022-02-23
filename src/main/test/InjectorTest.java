import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.weatherapiproject.Coord;
import com.sparta.weatherapiproject.WeatherInjector;
import com.sparta.weatherapiproject.ConnectionManager;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InjectorTest {
    private static final String TEST_URL = "";
    private static final String API_KEY = "";
    private static final double TEST_COORD_LON = 0;
    private static final double TEST_COORD_LAT = 0;

    private WeatherInjector wi;

    @Before
    public void setUp() {
        wi = new WeatherInjector();
    }

    @ParameterizedTest
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the coordinates data and store it in a Coordinates object.")
    @MethodSource("getJSONResponse")
    public void testCoordinatesRetrieval(String js) throws JsonProcessingException {
        Coord coord = wi.getCoordinates(js);
        Assertions.assertEquals(coord.getLon(), TEST_COORD_LON);
        Assertions.assertEquals(coord.getLat(), TEST_COORD_LAT);
    }

    private String getJSONString() {
        String s = ConnectionManager.currentWeatherDataConnection(TEST_URL, API_KEY);
        if(s != null) return s; // else
        return null; // replace with mockito
    }

}
