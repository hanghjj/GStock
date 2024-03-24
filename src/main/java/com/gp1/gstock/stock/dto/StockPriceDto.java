package com.gp1.gstock.stock.dto;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.Data;

@Data
public class StockPriceDto extends BaseEntity {

    private String bseDt;
    private String srtnCd;
    private Double stkPrpr;
    private Double prdyVrss;
    private String prdyVrssSign;
    private Double hgpr;
    private Double lwpr;
    private Double mxpr;
    private Double llam;
    private Double sdpr;
    private Double per;
    private Double pbr;
    private Double hgprW52;
    private Double lwprW52;

}
