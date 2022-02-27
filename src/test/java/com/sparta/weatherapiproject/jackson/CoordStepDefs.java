package com.sparta.weatherapiproject.jackson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CoordStepDefs {

    private Coord coord;
    private double value;

    @Given("I have a Coords")
    public void iHaveACoord() {
        coord = new Coord();
    }

    @When("I get the latitude")
    public void iGetTheLatitude() {
        value = coord.getLat();
    }

    @When("I get the longitude")
    public void iGetTheLongitude() {
        value = coord.getLon();
    }

    @Then("the value should be within the range of {int} and {int}")
    public void theValueShouldBeWithinTheRangeOfAnd(int min, int max) {
        Assertions.assertTrue(value >= min);
        Assertions.assertTrue(value <= max);
    }
}
