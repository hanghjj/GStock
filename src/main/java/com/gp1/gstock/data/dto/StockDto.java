package com.gp1.gstock.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDto extends BaseEntity{

    private String bseDt;
    private String srtnCd;
    private String itmNm;
    private Double mrktTotAmt;
    private String domeForeSeCd;
}
