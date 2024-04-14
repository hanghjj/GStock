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
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GS_STOCK")
@Data
@NoArgsConstructor
public class Stock extends BaseEntity {
    @Id
    private String srtnCd;
    private String itmNm;
    private String domeForeSeCd;

    public Stock(String srtnCd, String itmNm, String domeForeSeCd) {
        this.setSrtnCd(srtnCd);
        this.setItmNm(itmNm);
        this.setDomeForeSeCd(domeForeSeCd);
    }

    public Stock(StockDto stockDto) {
        BeanUtils.copyProperties(stockDto, this);
    }
}
