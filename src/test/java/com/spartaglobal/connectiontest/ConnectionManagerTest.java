package com.spartaglobal.connectiontest;

import com.sparta.weatherapiproject.ApiKeyGetter;
import com.sparta.weatherapiproject.ConnectionManager;
import com.sparta.weatherapiproject.UrlGenerator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class ConnectionManagerTest {
    @BeforeAll
    public String setUp(){
        String key = ApiKeyGetter.getApiKey();
        String url = UrlGenerator.getURL("london", key);
        return ConnectionManager.httpConnection(url);
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
//
//    @Test
//    @DisplayName("Test the connection manager returns a String")
//    public void testConnectionManagerReturnsString() {
//        String response = setUp();
//    }
//
//    @Test
//    @DisplayName("Test the connection manager returns a String")
//    public void testConnectionManagerReturnsString() {
//        String response = setUp();
//    }
//
//

}
