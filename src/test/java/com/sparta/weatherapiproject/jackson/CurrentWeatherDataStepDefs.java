package com.sparta.weatherapiproject.jackson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CurrentWeatherDataStepDefs {
    private CurrentWeatherData cwd;
    private Object obj;

    @Given("I have Current Weather Data for clear weather")
    public void iHaveCurrentWeatherDataForClearWeather() {
        cwd = new CurrentWeatherData();
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

    @Then("I should expect the object reference to be null")
    public void iShouldExpectTheObjectReferenceToBeNull() {
        Assertions.assertNull(obj);
    }
}
