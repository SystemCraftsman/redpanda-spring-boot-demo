package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaristaController {

    @Autowired
    private BaristaService baristaService;

    @PostMapping("/orders")
    public void processOrder(@RequestBody Order order) {
        baristaService.process(order);
    }

}
