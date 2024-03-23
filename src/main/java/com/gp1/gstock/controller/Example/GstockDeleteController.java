package com.gp1.gstock.controller.Example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/delete")
public class GstockDeleteController {

    @DeleteMapping(value = "/pathvar/{variable}")
    public String DeleteVairable(@PathVariable String variable){
        return variable + " deleted";
    }

    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return email + " deleted";
    }
}
