package com.mjanus.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-order")
    public void receive(String order) {
        System.out.println("Received the message: " + order);
    }
}
