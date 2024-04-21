package com.gp1.gstock.dividend.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GS_DIVIDEND")
@Data
@NoArgsConstructor
public class Dividend extends BaseEntity {
    @EmbeddedId
    private DividendId id;

    private Double dps;

    @Column(name = "PAY_PERD")
    private String payPerd;


    private Dividend(String userId, String bseYm, String srtnCd){
        this.id = new DividendId(userId,bseYm,srtnCd);
    }
}
