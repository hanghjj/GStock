package com.gp1.gstock.portpolio.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@EqualsAndHashCode(callSuper = true)
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioId extends BaseEntity {

    @Schema(name = "사용자ID")
    @Column(name = "USER_ID")
    private String userId;

    @Schema(name = "포트폴리오 ID")
    @Column(name = "PORTFOLIO_ID")
    private String portfolioId;
}
