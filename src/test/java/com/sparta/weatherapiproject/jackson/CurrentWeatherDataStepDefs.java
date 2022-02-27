package com.sparta.weatherapiproject.jackson;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CurrentWeatherDataStepDefs {
    private CurrentWeatherData cwd;
    private Object obj;
    private int integer;

    @Given("I have Current Weather Data")
    public void iHaveCurrentWeatherData() {
        cwd = new CurrentWeatherData();
    }

    @When("The weather is clear")
    public void theWeatherIsClear() {
        List<WeatherItem> wList = new ArrayList<>();
        WeatherItem wi = new WeatherItem();
        wi.setId(800);
        wi.setMain("Clear");
        wi.setDescription("clear sky");
        wi.setIcon("01d");
        wList.add(wi);
        cwd.setWeather(wList);
    }

    @When("I get the Rain")
    public void iGetTheRain() {
        obj = cwd.getRain();
    }

    @When("I get the Clouds")
    public void iGetTheClouds() {
        obj = cwd.getClouds();

    }

    @When("I get the Snow")
    public void iGetTheSnow() {
        obj = cwd.getSnow();
    }

    @When("I get the Timezone")
    public void iGetTheTimezone() {
        integer = cwd.getTimezone();
    }

    @Then("I should expect it to be null")
    public void iShouldExpectItToBeNull() {
        Assertions.assertNull(obj);
    }

    @When("I get Weather")
    public void iGetWeather() {
        obj = cwd.getWeather();
    }

    @Then("The integer value should be between {int} and {int}")
    public void theIntegerValueShouldBeBetweenAnd(int min, int max) {
        Assertions.assertTrue(integer >= min);
        Assertions.assertTrue(integer <= max);
    }

    @Then("I should expect it not to be null")
    public void iShouldExpectItNotToBeNull() {
        Assertions.assertNotNull(obj);
    }
}
