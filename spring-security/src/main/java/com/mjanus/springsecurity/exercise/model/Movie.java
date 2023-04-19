package com.mjanus.springsecurity.exercise.model;

import lombok.Data;
import lombok.Value;

@Data
@Value(staticConstructor = "of")
public class Movie {
    String title;
    String author;
    int year;
}