package com.sparta.weatherapiproject.stepdefs;

import com.sparta.weatherapiproject.jacksonclasses.Rain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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
