package com.sparta.weatherapiproject;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

public class ApiKeyGetter {
    public static String getApiKey() {
        Properties props = new Properties();
        try {
            props.load(new FileReader("apikey.properties"));
            return props.getProperty("apikey");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
