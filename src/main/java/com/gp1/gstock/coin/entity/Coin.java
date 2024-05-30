package com.gp1.gstock.coin.entity;

import com.gp1.gstock.coin.dto.CoinDto;
import com.gp1.gstock.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "GS_COIN")
@NoArgsConstructor
public class Coin extends BaseEntity {
    @Id
    private String ticker;
    @Column(name = "ITM_NM")
    private String itmNm;

    public Coin(CoinDto dto){
        BeanUtils.copyProperties(dto,this);
    }
}
