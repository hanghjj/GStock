package com.gp1.gstock.stock.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import com.gp1.gstock.stock.dto.StockDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GS_STOCK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock extends BaseEntity {

    @EmbeddedId
    private StockId stockId;

    private String itmNm;

    private Double mrktTotAmt;
    private String domeForeSeCd;

    public Stock(String bseDt, String srtnCd, String itmNm,Double mrktTotAmt,String domeForeSeCd){
        this.setStockId(new StockId(bseDt,srtnCd));
        this.setItmNm(itmNm);
        this.setMrktTotAmt(mrktTotAmt);
        this.setDomeForeSeCd(domeForeSeCd);
    }

    public Stock(StockDto stockDto){
        BeanUtils.copyProperties(stockDto,this);
        this.setStockId(new StockId(stockDto.getBseDt(), stockDto.getSrtnCd()));
    }

    public String getBseDt(){return this.stockId.getBseDt();}
    public String getSrtnCd(){return this.stockId.getSrtnCd();}
}
