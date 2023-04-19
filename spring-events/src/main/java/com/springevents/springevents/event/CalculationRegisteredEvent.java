package com.springevents.springevents.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class CalculationRegisteredEvent extends ApplicationEvent {
    private final float firstNumber;
    private final float secondNumber;
    private final float result;

    public CalculationRegisteredEvent(Object source, float firstNumber, float secondNumber, float result) {
        super(source);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }
}