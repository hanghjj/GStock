package com.gp1.gstock.dividend.controller;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.dividend.entity.Dividend;
import com.gp1.gstock.dividend.service.DividendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
@Tag(name = "Dividend" , description = "배당 관련 API")
@RequestMapping("/api/dividend")
public class DividendController {

    private final DividendService service;

    @Operation(summary = "배당 조회", description = "배당금을 DB에서 조회한다.")
    @GetMapping("/search")
    @Tag(name = "Dividend")
    public ResponseEntity<Dividend> getDividend(
            @Parameter(name = "bseYm", description = "기준년월") @RequestParam(value = "bseYm") String bseYm,
            @Parameter(name = "srtnCd", description = "종목코드")@RequestParam(value = "srtnCd") String srtnCd
    ){
        Dividend dividend = service.selectDividend(bseYm,srtnCd);
        if(dividend==null){
            throw new CustomException("dividend.search.fail");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dividend);
    }

}
