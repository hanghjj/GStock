package com.gp1.gstock.common.Exception;

import com.gp1.gstock.common.service.CommonService;
import org.springframework.stereotype.Service;

@Service
public class CustomExceptionService {
    private static CommonService commonService;

    CustomExceptionService(CommonService commonService){
        CustomExceptionService.commonService = commonService;
    }
    public static String getMsg(String code){
        if(commonService==null) System.out.println("isNull");
        else return commonService.selectMsgCd(code).getMessage();
        return "common serivce is null";
    }
}
