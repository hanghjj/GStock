package com.gp1.gstock.coin.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "GS_COIN_PRICE")
public class CoinPrice extends BaseEntity {
    @EmbeddedId
    private CoinPriceId id;
    @Schema(description = "현재가격")
    private Double prpr;
    @Schema(description = "최고가")
    private Double hgpr;
    @Schema(description = "최저가")
    private Double lwpr;
}
