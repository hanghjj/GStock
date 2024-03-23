package com.gp1.gstock.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class StockPriceId implements Serializable {
    private String bseDt;
    private String srtnCd;

    public StockPriceId(String bseDt, String srtnCd) {
        this.bseDt = bseDt;
        this.srtnCd = srtnCd;
    }
}
