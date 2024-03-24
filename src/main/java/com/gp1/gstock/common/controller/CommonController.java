package com.gp1.gstock.common.controller;

import com.gp1.gstock.common.entity.MsgCd;
import com.gp1.gstock.common.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comm")
@AllArgsConstructor
public class CommonController {
    private final CommonService commonService;
    @GetMapping("/msg/add")
    public ResponseEntity<MsgCd> insertNewMessage (String cd, String msg){
        MsgCd msgCd = new MsgCd(cd,msg);
        commonService.insertMsgCd(msgCd);
        return ResponseEntity.status(HttpStatus.OK).body(msgCd);
    }
}
