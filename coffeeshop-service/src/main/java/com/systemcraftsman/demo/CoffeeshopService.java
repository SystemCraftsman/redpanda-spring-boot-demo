package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoffeeshopService {

    // TODO: Replace the RestTemplate with KafkaTemplate
    @Autowired
    private RestTemplate restTemplate;

    // TODO: In the method use the KafkaTemplate to send the messages to the `orders` topic instead of using RestTemplate
    public void sendOrder(Order order) {
        String orderURL = "http://localhost:8081/orders";
        restTemplate.postForObject(orderURL, order, Order.class);
    }

}