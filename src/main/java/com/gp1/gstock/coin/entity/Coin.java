package com.gp1.gstock.coin.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "GS_COIN")
public class Coin extends BaseEntity {
    @Id
    private String ticker;
    @Column(name = "ITM_NM")
    private String itmNm;
}
