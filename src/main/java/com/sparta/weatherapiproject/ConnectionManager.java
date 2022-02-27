package com.sparta.weatherapiproject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {

    public String httpConnection(String url) {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
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
