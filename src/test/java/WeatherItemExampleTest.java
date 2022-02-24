import com.sparta.weatherapiproject.ApiKeyGetter;
import com.sparta.weatherapiproject.WeatherInjector;
import com.sparta.weatherapiproject.jackson.WeatherItem;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

import java.io.IOException;
import java.util.regex.Matcher;

public class WeatherItemExampleTest {
    private WeatherItem weatherItem;
    private String icon;
    private String description;

    @Given("I have a weather item")
    public void iHaveAWeatherItem() {
        System.out.println("Weather Item");
        try {
            weatherItem = new WeatherInjector().getCurrentWeatherData(35, 139, ApiKeyGetter.getApiKey()).getWeather().get(0);
            System.out.println(weatherItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assumptions.assumeTrue(weatherItem != null);

    }

    @And("description is few clouds")
    public void descriptionIsFewClouds() {
        Assertions.assertEquals("few clouds", weatherItem.getDescription());
    }

    @When("I get Icon")
    public void iGetIcon() {
        icon = weatherItem.getIcon();
    }



    @Then("The value should be either {string} or {string}")
    public void theValueShouldBeEitherOr(String arg0, String arg1) {
        MatcherAssert.assertThat(icon, Matchers.oneOf(arg0, arg1));
    }
}
