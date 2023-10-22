package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoffeeshopService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendOrder(Order order) {
        String orderURL = "http://localhost:8081/orders";
        restTemplate.postForObject(orderURL, order,  Order.class);
    }

}