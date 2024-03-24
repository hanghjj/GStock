package com.gp1.gstock.common.Exception;

public class CustomException extends Exception{


    public CustomException(){
        super();
    }

    public CustomException(String code){
        super(CustomExceptionService.getMsg(code));
    }

}
