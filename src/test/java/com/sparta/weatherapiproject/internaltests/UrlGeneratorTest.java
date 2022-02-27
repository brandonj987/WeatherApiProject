package com.sparta.weatherapiproject.internaltests;

import com.sparta.weatherapiproject.getresponse.ApiKeyGetter;
import com.sparta.weatherapiproject.getresponse.UrlGenerator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class UrlGeneratorTest {

    @BeforeAll
    public String setUpKey(){
        return ApiKeyGetter.getApiKey();
    }

    // city name
    @Test
    @DisplayName("Given a city name, return a string")
    public void givenACityName_ReturnAString(){
        Class actual = UrlGenerator.getURL("london", setUpKey()).getClass();
        Class expected = "".getClass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a city name, return a string that begins with https://")
    public void givenACityName_ReturnAStringThatStartsWithHttps(){
        String url = UrlGenerator.getURL("london", setUpKey());
        String actual = url.substring(0, 8);
        String expected= "https://";
        Assertions.assertEquals(expected, actual);
    }

    // long lat
    @Test
    @DisplayName("Given longitude and latitude coords, return a string")
    public void givenLongLatCoords_ReturnAString(){
        Class actual = UrlGenerator.getURL(-122.08, 37.39, setUpKey()).getClass();
        Class expected = "".getClass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given longitude and latitude coords, return a string that begins with https://")
    public void givenLongLatCoords_ReturnAStringThatStartsWithHttps(){
        String url = UrlGenerator.getURL(-122.08, 37.39, setUpKey());
        String actual = url.substring(0, 8);
        String expected= "https://";
        Assertions.assertEquals(expected, actual);
    }

    // city and statecode
    @Test
    @DisplayName("Given a city name and state code, return a string")
    public void givenACityNameAndStateCode_ReturnAString(){
        Class actual = UrlGenerator.getURL("austin", "tx", setUpKey()).getClass();
        Class expected = "".getClass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a city name and state code, return a string that begins with https://")
    public void givenACityNameAndStateCode_ReturnAStringThatStartsWithHttps(){
        String url = UrlGenerator.getURL("austin", "tx", setUpKey());
        String actual = url.substring(0, 8);
        String expected= "https://";
        Assertions.assertEquals(expected, actual);
    }

    // city, state, country
    @Test
    @DisplayName("Given a city name, state code and country, return a string")
    public void givenACityNameStateCodeAndCountry_ReturnAString(){
        Class actual = UrlGenerator.getURL("austin", "tx", "us", setUpKey()).getClass();
        Class expected = "".getClass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a city name, state code and country, return a string that begins with https://")
    public void givenACityNameStateCodeAndCountry_ReturnAStringThatStartsWithHttps(){
        String url = UrlGenerator.getURL("austin", "tx", "us", setUpKey());
        String actual = url.substring(0, 8);
        String expected= "https://";
        Assertions.assertEquals(expected, actual);
    }

    // city id
    @Test
    @DisplayName("Given a city id, return a string")
    public void givenACityId_ReturnAString(){
        Class actual = UrlGenerator.getURL(800, setUpKey()).getClass();
        Class expected = "".getClass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a city id, return a string that begins with https://")
    public void givenACityId_ReturnAStringThatStartsWithHttps(){
        String url = UrlGenerator.getURL(800, setUpKey());
        String actual = url.substring(0, 8);
        String expected= "https://";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Given a zip code and country, return a string")
    public void givenAZipCodeAndCountry_ReturnAString(){
        Class actual = UrlGenerator.getURL(20500, "us", setUpKey()).getClass();
        Class expected = "".getClass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a zip code and country, return a string that begins with https://")
    public void givenAZipCodeAndCountry_ReturnAStringThatStartsWithHttps(){
        String url = UrlGenerator.getURL(20500, "us", setUpKey());
        String actual = url.substring(0, 8);
        String expected= "https://";
        Assertions.assertEquals(expected, actual);
    }




}
