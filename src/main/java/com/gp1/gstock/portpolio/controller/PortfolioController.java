package com.gp1.gstock.portpolio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.common.utils.DateTimeUtils;
import com.gp1.gstock.portpolio.dto.PortfolioDto;
import com.gp1.gstock.portpolio.service.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@Tag(name = "Portfolio", description = "포트폴리오 관련 API")
@RequestMapping("/api/portfolio")
public class PortfolioController {
    private final PortfolioService service;

    @GetMapping("/insert/detail")
    @Operation(summary = "포트폴리오 종목 추가", description = "포트폴리오 종목 추가")
    @Tag(name = "Portfolio")
    public ResponseEntity<PortfolioDto> insertPortfolioDetails(
            @Parameter(name = "userId", description = "사용자ID") @RequestParam(name = "userId", required = true) String userId,
            @Parameter(name = "portfolioId", description = "포트폴리오ID") @RequestParam(name = "portfolioId", required = true) String portfolioId,
            @Parameter(name = "ticker", description = "티커") @RequestParam(name = "ticker", required = false) String ticker,
            @Parameter(name = "asstSeCd", description = "자산구분코드",
                    examples = {
                            @ExampleObject(name = "Stock", value = "S"),
                            @ExampleObject(name = "Coin", value = "C"),
                            @ExampleObject(name = "KRW", value = "K"),
                            @ExampleObject(name = "USD", value = "U")
                    }
            ) @RequestParam(name = "asstSeCd", required = false) String asstSeCd,
            @Parameter(name = "qty", description = "보유수량") @RequestParam(name = "qty", required = false) Double qty,
            @Parameter(name = "avgPcsPce", description = "매수평균가") @RequestParam(name = "avgPcsPce", required = false) Double avgPcsPce) throws JsonProcessingException {
        PortfolioDto dto = new PortfolioDto(userId, portfolioId, asstSeCd, ticker, qty, avgPcsPce);
        service.insertPortfolio(dto);
        dto = service.getLatestPrice(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/get/detail")
    @Operation(summary = "포트폴리오 세부정보 조회", description = "포트폴리오 세부정보 조회")
    @Tag(name = "Portfolio")
    public ResponseEntity<List<PortfolioDto>> getPortfolioDetails(
            @Parameter(name = "userId", description = "사용자ID") @RequestParam(name = "userId", required = true) String userId,
            @Parameter(name = "portfolioId", description = "포트폴리오ID") @RequestParam(name = "portfolioId", required = true) String portfolioId
    ) {

        //userId 검증 필요
        List<PortfolioDto> resultList = service.getPortfolioDetailList(portfolioId);
        resultList.forEach(dto ->{
            dto.setUserId(userId);
            dto.setUpYmd(DateTimeUtils.getDateFormat("yyyyMMdd"));
        });
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/get/list")
    @Operation(summary = "포트폴리오 목록 조회", description = "포트폴리오 목록 조회")
    @Tag(name = "Portfolio")
    public ResponseEntity<List<PortfolioDto>> getPortfolioDetails(
            @Parameter(name = "userId", description = "사용자ID") @RequestParam(name = "userId", required = true) String userId
    ) {
        return ResponseEntity.ok(service.getPortfolioList(userId));
    }

}
