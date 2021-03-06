package com.sparta.weatherapiproject.internaltests;

import com.sparta.weatherapiproject.getresponse.ApiKeyGetter;
import com.sparta.weatherapiproject.getresponse.ConnectionManager;
import com.sparta.weatherapiproject.getresponse.UrlGenerator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class ConnectionManagerTest {
    @BeforeAll
    public String setUp(){
        String key = ApiKeyGetter.getApiKey();
        String url = UrlGenerator.getURL("london", key);
        return (new ConnectionManager()).httpConnection(url);
    }

    @Test
    @DisplayName("Test the connection manager returns a String")
    public void testConnectionManagerReturnsString(){
        String response = setUp();
        Class actual = response.getClass();
        Class expected = "".getClass();
        System.out.println(response);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the connection manager body returns a 200 status code")
    public void testConnectionManagerReturns200StatusCode() {
        String response = setUp();
        String actual = response.substring(response.length() -  4, response.length() - 1);
        String expected = "200";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the connection response starts with {")
    public void testConnectionManagerStartsWithLeftCurly() {
        String response = setUp();
        String actual = response.substring(0, 1);
        String expected = "{";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test the connection response ends with }")
    public void testConnectionManagerEndsWithRightCurly() {
        String response = setUp();
        String actual = response.substring(response.length() - 1);
        String expected = "}";
        System.out.println(actual);
        Assertions.assertEquals(expected, actual);

    }
}
