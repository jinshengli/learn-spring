package com.ljs.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * create by ljs on 2020/6/13 19:05
 * <p>
 * description:
 */

@Component("school")
public class School {

    @Value("${school.name}")
    private String name;
    @Value("${school.address}")
    private String adress;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
