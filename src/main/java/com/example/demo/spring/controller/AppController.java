package com.example.demo.spring.controller;

import com.example.demo.spring.model.Message;
import com.example.demo.spring.model.FactoryClass;
import com.example.demo.spring.model.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    private FactoryClass factoryClass;
    private Observer observer;

    @GetMapping("/get-class")
    public ResponseEntity<String> getClass(@RequestParam String type) {
        try {
            observer =  factoryClass.create(type);
            Message message = (Message) observer;
            return ResponseEntity.ok(message.getMessage());
        } catch (ClassNotFoundException e) {
            return ResponseEntity.badRequest().body("Invalid class type");
        }
    }

    @GetMapping("/get-message")
    public ResponseEntity<String> getMessage(@RequestParam String message) {
            return ResponseEntity.ok(observer.update(message));
    }
}
