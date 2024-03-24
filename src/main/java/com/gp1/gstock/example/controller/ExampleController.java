package com.gp1.gstock.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
