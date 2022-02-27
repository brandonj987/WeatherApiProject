package com.sparta.weatherapiproject.jackson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class RainStepDefs {
    private Rain rain;
    private Double aDouble;

    @Given("I have rain data")
    public void iHaveRainData() {
        rain = new Rain();
    }

    @When("I get the rain over the past hour")
    public void iGetTheRainOverThePastHour() {
        aDouble = rain.getJsonMember1h();
    }
}
