package com.mjanus.db;

public interface WeatherRetriever {
    String getFirstWeather() throws InterruptedException;
    String getSecondWeather() throws InterruptedException;
    String getThirdWeather() throws InterruptedException;
}
