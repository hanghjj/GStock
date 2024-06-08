package com.gp1.gstock.portpolio.dto;

import com.gp1.gstock.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PortfolioDto extends BaseEntity {
    private String userId;
    private String portfolioId;
    private String upYmd;
    @Schema(name = "자산 구분 코드", allowableValues = {"C","S","U","K"})
    private String assetSeCd;
    @Schema(name = "주식코드 OR 티커")
    private String ticker;
    @Schema(name = "수량")
    private String qty;
    @Schema(name = "매수평균가")
    private String avgPcsPce;
    @Schema(name = "평가금액")
    private Double mktPce;
    @Schema(name = "평가손익")
    private Double mktPnl;
}
