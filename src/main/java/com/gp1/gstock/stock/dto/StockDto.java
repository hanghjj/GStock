package com.gp1.gstock.stock.dto;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class StockDto extends BaseEntity {
    private String srtnCd;
    private String itmNm;
    private String domeForeSeCd;
    private String excd;
    private String bseDt;
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
