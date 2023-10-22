package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Barista;
import com.systemcraftsman.demo.model.Beverage;
import com.systemcraftsman.demo.model.BeverageState;
import com.systemcraftsman.demo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BaristaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaristaService.class);

    @Autowired
    private Barista barista;

    public void process(Order order) {
        prepare(order);
    }

    // TODO: Annotate the method with @KafkaListener annotation for topic `orders`
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

    public int getPreparationTime() {
        return random.nextInt(5) * 1000;
    }

    public Beverage createFallbackBeverage(Order order) {
        return new Beverage(order,"", BeverageState.FAILED);
    }

}