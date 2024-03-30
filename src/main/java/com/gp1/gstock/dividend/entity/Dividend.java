package com.gp1.gstock.dividend.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GS_DIVIDEND")
@Data
public class Dividend extends BaseEntity {
    @EmbeddedId
    private DividendId id;

    private Double dps;

    @Column(name = "PAY_PERD")
    private String payPerd;


    private Dividend(String bseYm, String srtnCd){
        this.id = new DividendId(bseYm,srtnCd);
    }
}
