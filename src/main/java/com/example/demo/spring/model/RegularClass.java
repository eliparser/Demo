package com.example.demo.spring.model;

public class RegularClass implements Message, Observer {
    private String claasMessage = "";

    @Override
    public String getMessage() {
        claasMessage = "regular class";
        return claasMessage;
    }

    @Override
    public String update(String message) {
        claasMessage = message;
        return claasMessage;
    }
}
