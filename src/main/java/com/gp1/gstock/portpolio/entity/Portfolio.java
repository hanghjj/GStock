package com.gp1.gstock.portpolio.entity;

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
@Table(name = "GS_PORTFOLIO")
@Data
@NoArgsConstructor
public class Portfolio extends BaseEntity {

    @EmbeddedId
    private PortfolioId id;

    @Column(name = "UP_YMD")
    private String upYmd;

}
