package com.systemcraftsman.demo.model;

import com.systemcraftsman.demo.util.NameUtil;
import org.springframework.stereotype.Component;

@Component
public class Barista {
    private String name;

    public String getName() {
        if (null == name){
            name = NameUtil.getRandomName();
        }
        return name;
    }
}