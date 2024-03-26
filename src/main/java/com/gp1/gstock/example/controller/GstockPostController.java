package com.gp1.gstock.example.controller;

import com.gp1.gstock.example.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
public class GstockPostController {
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String postExample(){
        return "[Post] Hello World!";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, String> postData){

        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
                sb.append(map.getKey() + " : " + map.getValue());
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String getRequestParam3(@RequestBody MemberDto member){
        return member.toString();
    }
}
