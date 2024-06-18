package com.gp1.gstock.portpolio.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode(callSuper = true)
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDetailId extends BaseEntity {
    @Schema(name = "포트폴리오ID")
    @Column(name = "PORTFOLIO_ID")
    private String portfolioId;

    @Schema(name = "티커")
    @Column(name = "TICKER")
    private String ticker;
}
