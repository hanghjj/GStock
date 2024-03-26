package com.gp1.gstock.example.controller;


import com.gp1.gstock.example.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/v1/get")
public class GstockGetController{

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "[GET] Hello World!";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String str){
        return str;
    }
    @ApiOperation(value = "GET 메소드 예제", notes = "@ReqeustParam을 이용한 Get Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization
    ){
        log.info("EXECUTE Method getRequestParam1");
        return "이름 : " + name + "이메일 : " + email + "소속 : " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue());
            sb.append("\n");
        });

        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto member){
        return member.toString();
    }
}
