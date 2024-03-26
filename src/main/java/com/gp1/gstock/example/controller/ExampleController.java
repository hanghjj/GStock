package com.gp1.gstock.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ExampleController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Yejin!";
    }
}
