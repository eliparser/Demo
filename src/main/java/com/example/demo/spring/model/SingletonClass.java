package com.example.demo.spring.model;

public class SingletonClass implements Message, Observer {
    private static SingletonClass INSTANCE = null;
    private String claasMessage = "";


    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonClass();
        }
        return INSTANCE;
    }

    @Override
    public String getMessage() {
        claasMessage = "singleton class";
        return claasMessage;
    }

    @Override
    public String update(String message) {
        claasMessage = message;
        return claasMessage;
    }
}
