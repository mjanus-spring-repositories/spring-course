package com.mjanus.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping
    public void processOrder(@RequestBody Order order) {
        jmsTemplate.convertAndSend("queue-order", order.toString());
    }
}