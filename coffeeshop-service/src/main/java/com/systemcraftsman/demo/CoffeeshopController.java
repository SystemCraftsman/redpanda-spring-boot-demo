package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeshopController {

    @Autowired
    private CoffeeshopService coffeeshopService;

    @PostMapping("/orders")
    public String sendOrder(@RequestBody Order order) {
        try {
            coffeeshopService.sendOrder(order);
            return "\nOrder sent: " + order.toString();
        }
        catch(Exception e) {
            return "\nException: " + e.getMessage();
        }
    }

}