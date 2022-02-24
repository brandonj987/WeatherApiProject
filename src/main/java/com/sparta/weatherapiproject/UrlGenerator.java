package com.sparta.weatherapiproject;

public class UrlGenerator {

    private static final String URL_START = "https://api.openweathermap.org/data/2.5/weather?";

    public static String getURL(double lon, double lat, String apiKey) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(URL_START);
        stringbuilder.append("lat=");
        stringbuilder.append(lat);
        stringbuilder.append("&lon=");
        stringbuilder.append(lon);
        stringbuilder.append("&appid=");
        stringbuilder.append(apiKey);
        return stringbuilder.toString();
    }

    public static String getURL(String cityName,String apiKey) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(URL_START);
        stringbuilder.append("q=");
        stringbuilder.append(cityName);
        stringbuilder.append("&appid=");
        stringbuilder.append(apiKey);
        return stringbuilder.toString();
    }


    public static String getURL(String cityName, String stateCode, String apiKey) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(URL_START);
        stringbuilder.append("q=");
        stringbuilder.append(cityName);
        stringbuilder.append(",");
        stringbuilder.append(stateCode);
        stringbuilder.append("&appid=");
        stringbuilder.append(apiKey);
        return stringbuilder.toString();
    }


    public static String getURL(String cityName, String stateCode, String countryCode, String apiKey) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(URL_START);
        stringbuilder.append("q=");
        stringbuilder.append(cityName);
        stringbuilder.append(",");
        stringbuilder.append(stateCode);
        stringbuilder.append(",");
        stringbuilder.append(countryCode);
        stringbuilder.append("&appid=");
        stringbuilder.append(apiKey);
        return stringbuilder.toString();
    }

}
