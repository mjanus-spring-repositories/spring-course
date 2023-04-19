package com.mjanus.model;

import com.mjanus.db.WeatherRetriever;

import java.util.Random;

public class Weather {
    private String description;

    public Weather(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void changeWeather(WeatherRetriever weatherRetriever) throws InterruptedException {
        int weatherType = new Random().nextInt(1,3);
        final int FIRST_OPTION = 1;
        if(this.getDescription().equals(weatherRetriever.getFirstWeather())) {
            if(weatherType == FIRST_OPTION) this.setDescription(weatherRetriever.getSecondWeather());
            else this.setDescription(weatherRetriever.getThirdWeather());
        } else if (this.getDescription().equals(weatherRetriever.getSecondWeather())) {
            if(weatherType == FIRST_OPTION) this.setDescription(weatherRetriever.getFirstWeather());
            else this.setDescription(weatherRetriever.getThirdWeather());
        } else {
            if(weatherType == FIRST_OPTION) this.setDescription(weatherRetriever.getFirstWeather());
            else this.setDescription(weatherRetriever.getSecondWeather());
        }
        System.out.println("Weather changed to " + this.getDescription());
    }
}
