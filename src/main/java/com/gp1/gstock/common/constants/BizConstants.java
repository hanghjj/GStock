package com.gp1.gstock.common.constants;

import lombok.Getter;

@Getter
public enum BizConstants {
    PROJECT_NAME("Gstock"),
    ADMINISTRATOR("A"),
    NORMAL("N"),
    DEFAULT_ERR_MSG("system.error"),
    ;

    private final String val;
    BizConstants(String val) {
        this.val = val;
    }
    public String value(){
        return this.getVal();
    }
}
