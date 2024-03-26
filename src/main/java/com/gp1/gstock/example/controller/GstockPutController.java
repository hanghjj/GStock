package com.gp1.gstock.example.controller;

import com.gp1.gstock.example.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put")
public class GstockPutController {
    @PutMapping(value = "/member")
    public String putMember1(@RequestBody Map<String, String> putData){

        StringBuilder sb = new StringBuilder();

        putData.forEach((key, value) -> sb.append(key).append(" : ").append(value));

        return sb.toString();
    }


    @PutMapping(value = "/member2")
    public MemberDto putMember2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> putMember3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
