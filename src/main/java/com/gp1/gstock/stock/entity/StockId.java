package com.gp1.gstock.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class StockId implements Serializable {
    private String bseDt;
    private String srtnCd;

    public StockId(String bseDt, String srtnCd) {
        this.bseDt = bseDt;
        this.srtnCd = srtnCd;
    }
}
