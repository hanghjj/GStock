package com.gp1.gstock.common.aop;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.constants.BizConstants;
import com.gp1.gstock.common.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@AllArgsConstructor
public class RestControllerExceptionHandler {

    private final CommonService commonService;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> CustomException(CustomException e){
        String cd = e.getMessageCode();
        List<String> params = Optional.ofNullable(e.getParams()).orElse(Collections.emptyList());
        String msg = commonService.selectMsgCd(cd).getMessage();
        if("".equals(msg)) return new ResponseEntity<>(BizConstants.DEFAULT_ERR_MSG,HttpStatus.INTERNAL_SERVER_ERROR);
        for(int i = 0; i<params.size(); i++){
            msg = msg.replace("@"+(i+1)+"@", params.get(i));
        }
        return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
