import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InjectorTest {
    private static final double TEST_COORDINATES_LON = 0;
    private static final double TEST_COORDINATES_LAT = 0;

    @ParameterizedTest
    @DisplayName("Given a JSON Object, the injector should be able to retrieve" +
            "the coordinates data and store it in a Coordinates object.")
    @MethodSource("getJSONObject")
    public static void testCoordinatesRetrieval(JSONObject jObj) {
        Coordinates coordinates = Injector.getCoordinates(jObj);

    }

    private static JSONObject getJSONObject() {
        JSONObject jo = null;
        JSONParser jp = new JSONParser();
        try {
            jo = (JSONObject) jp.parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return jo;
        }
    }

}
