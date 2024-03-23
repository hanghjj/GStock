package com.gp1.gstock.data.entity;

import com.gp1.gstock.data.dto.StockPriceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GS_STOCK_PRICE")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StockPrice {
    @EmbeddedId
    private StockPriceId stockPriceId;
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
    @Column(name = "HGPR_W52")
    private Double hgprW52;
    @Column(name = "LWPR_W52")
    private Double lwprW52;

    public StockPrice(StockPriceDto stockPriceDto) {
        BeanUtils.copyProperties(stockPriceDto, this);
        this.stockPriceId = new StockPriceId(stockPriceDto.getBseDt(), stockPriceDto.getSrtnCd());
    }
}
