package com.gp1.gstock.coin.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@EqualsAndHashCode(callSuper = true)
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinPriceId extends BaseEntity {
    private String bseDt;
    private String ticker;
}
