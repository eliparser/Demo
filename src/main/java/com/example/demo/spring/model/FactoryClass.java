package com.example.demo.spring.model;

import org.springframework.stereotype.Service;

@Service
public class FactoryClass {

    public Observer create(String type) throws ClassNotFoundException {
        if (type.equals("regular")) {
            return new RegularClass();
        } else if (type.equals("singleton")) {
            return SingletonClass.getInstance();
        } else {
            throw new ClassNotFoundException("not found");
        }
    }
}
