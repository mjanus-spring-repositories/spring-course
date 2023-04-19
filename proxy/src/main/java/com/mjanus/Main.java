package com.mjanus;

import com.mjanus.db.WeatherRetriever;
import com.mjanus.db.LazyWeatherRetrieverProxy;
import com.mjanus.model.Weather;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Weather weather = new Weather("Sunny");
        for (int n = 0; n < 5; n++) {
            WeatherRetriever weatherRetriever = new LazyWeatherRetrieverProxy();
            int number = new Random().nextInt(100);
            if (number < 20) {
                weather.changeWeather(weatherRetriever);
            }
            System.out.println("Weather is still " + weather.getDescription());
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}