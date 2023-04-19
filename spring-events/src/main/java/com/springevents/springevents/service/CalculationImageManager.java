package com.springevents.springevents.service;

import com.springevents.springevents.event.CalculationRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CalculationImageManager implements ApplicationListener<CalculationRegisteredEvent> {

    @Override
    public void onApplicationEvent(CalculationRegisteredEvent event) {
        log.info(String.format("Provided %f and %f, result of the calculation is %f",
                event.getFirstNumber(), event.getSecondNumber(), event.getResult()));
    }

}