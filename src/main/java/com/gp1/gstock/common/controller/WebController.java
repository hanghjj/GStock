package com.gp1.gstock.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController implements ErrorController {
    //ContextPath에 gstock 추가할 것
    @GetMapping("/error")
    public String index() {
        return "index.html";
    }
}
