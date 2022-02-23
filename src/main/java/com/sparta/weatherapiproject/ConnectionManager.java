package com.sparta.weatherapiproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.weatherapiproject.jackson.CurrentWeatherData;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {

    public static String httpConnection(String url, String apiKey) {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url+apiKey))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            return responseBody;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
