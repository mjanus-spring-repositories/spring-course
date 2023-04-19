package com.springevents.springevents.controller;

import com.springevents.springevents.event.CalculationRegisteredEvent;
import com.springevents.springevents.model.Calculation;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculations")
public class CalculationController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @PostMapping(path = "add")
    public void addNumbers(@RequestBody Calculation calculation) {
        float firstNumber = calculation.getFirstNumber();
        float secondNumber = calculation.getSecondNumber();
        publisher.publishEvent(new CalculationRegisteredEvent(
                this, firstNumber, secondNumber, firstNumber + secondNumber));
    }

    @PostMapping(path = "subtract")
    public void subtractNumbers(@RequestBody Calculation calculation) {
        float firstNumber = calculation.getFirstNumber();
        float secondNumber = calculation.getSecondNumber();
        publisher.publishEvent(new CalculationRegisteredEvent(
                this, firstNumber, secondNumber, firstNumber - secondNumber));
    }

    @PostMapping(path = "multiple")
    public void multipleNumbers(@RequestBody Calculation calculation) {
        float firstNumber = calculation.getFirstNumber();
        float secondNumber = calculation.getSecondNumber();
        publisher.publishEvent(new CalculationRegisteredEvent(
                this, firstNumber, secondNumber, firstNumber * secondNumber));
    }

    @PostMapping(path = "divide")
    public void divideNumbers(@RequestBody Calculation calculation) {
        float firstNumber = calculation.getFirstNumber();
        float secondNumber = calculation.getSecondNumber();
        publisher.publishEvent(new CalculationRegisteredEvent(
                this, firstNumber, secondNumber, firstNumber / secondNumber));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}