package com.mjanus.converter.domain;

public class Report {

    private final String name;
    private final String description;
    private final int cost;

    public Report(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }
}