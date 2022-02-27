package com.sparta.weatherapiproject.stepdefs;

import com.sparta.weatherapiproject.jacksonclasses.Wind;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WindStepDefs {
    private Wind wind;

    @Given("I have Wind Data")
    public void iHaveWindData() {
        wind = new Wind();
    }

    @When("I have no Gust data")
    public void iHaveNoGustData() {
    }

    @Then("I should expect Gust to be null")
    public void iShouldExpectGustToBeNull() {
        Assertions.assertNull(wind.getGust());
    }
}
