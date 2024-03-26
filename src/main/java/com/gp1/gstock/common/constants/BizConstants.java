package com.gp1.gstock.common.constants;

import lombok.Getter;

@Getter
public enum BizConstants {
    ADMINISTRATOR("A"),
    NORMAL("N"),
    DEFAULT_ERR_MSG("system.error");

    private final String val;
    BizConstants(String val) {
        this.val = val;
    }
}
