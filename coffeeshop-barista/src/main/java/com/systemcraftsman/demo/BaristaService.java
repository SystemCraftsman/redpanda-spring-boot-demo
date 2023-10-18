package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Barista;
import com.systemcraftsman.demo.model.Beverage;
import com.systemcraftsman.demo.model.BeverageState;
import com.systemcraftsman.demo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BaristaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaristaService.class);

    @Autowired
    private Barista barista;

    @KafkaListener(topics = "orders", groupId = "baristas")
    public void process(Order order) {
        prepare(order);
    }

    private void prepare(Order order) {
        int delay = getPreparationTime();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LOGGER.info("{}", new Beverage(order, barista.getName(), BeverageState.READY));
    }

    private Random random = new Random();

    int getPreparationTime() {
        return random.nextInt(5) * 1000;
    }

}