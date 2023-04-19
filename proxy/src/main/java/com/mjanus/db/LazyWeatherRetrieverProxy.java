package com.mjanus.db;

public class LazyWeatherRetrieverProxy implements WeatherRetriever {

    private WeatherRetriever retriever;

    @Override
    public String getFirstWeather() throws InterruptedException {
        if (retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.getFirstWeather();
    }

    @Override
    public String getSecondWeather() throws InterruptedException {
        if (retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.getSecondWeather();
    }

    @Override
    public String getThirdWeather() throws InterruptedException {
        if (retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.getThirdWeather();
    }

}