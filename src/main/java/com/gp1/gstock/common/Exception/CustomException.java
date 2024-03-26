package com.gp1.gstock.common.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomException extends RuntimeException {
    private String messageCode;

    private List<String> params;

    public CustomException() {
        super();
    }

    public CustomException(String code) {
        super(code);
        this.messageCode = code;
    }

    public CustomException(String code, List<String> params) {
        super(code);
        this.messageCode = code;
        this.params = params;
    }

}
