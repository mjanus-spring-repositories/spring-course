package com.mjanus.db;

public class WeatherDataRetriever implements WeatherRetriever {

    public WeatherDataRetriever() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Override
    public String getFirstWeather() {
        return "Sunny";
    }

    @Override
    public String getSecondWeather() {
        return "Cloudy";
    }

    @Override
    public String getThirdWeather() {
        return "Rainy";
    }
}