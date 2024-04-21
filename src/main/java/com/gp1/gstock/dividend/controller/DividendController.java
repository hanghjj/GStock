package com.gp1.gstock.dividend.controller;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.service.CommonService;
import com.gp1.gstock.dividend.entity.Dividend;
import com.gp1.gstock.dividend.entity.DividendId;
import com.gp1.gstock.dividend.service.DividendService;
import com.gp1.gstock.dividend.utils.DividendUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.gp1.gstock.common.constants.BizConstants.DEFAULT_ERR_MSG;

@Controller
@Slf4j
@AllArgsConstructor
@Tag(name = "Dividend", description = "배당 관련 API")
@RequestMapping("/api/dividend")
public class DividendController {

    private final DividendService service;
    private final CommonService commonService;

    @Operation(summary = "배당 조회", description = "배당금을 DB에서 조회한다.", responses = {
            @ApiResponse(responseCode = "200", description = "정상적으로 조회되었습니다."),
            @ApiResponse(responseCode = "500", description = DEFAULT_ERR_MSG)
    })
    @GetMapping("/search")
    @Tag(name = "Dividend")
    public ResponseEntity<Dividend> getDividend(
            @Parameter(name = "userId", description = "사용자 아이디") @RequestParam(value = "userId") String userId,
            @Parameter(name = "bseYm", description = "기준년월") @RequestParam(value = "bseYm") String bseYm,
            @Parameter(name = "srtnCd", description = "종목코드") @RequestParam(value = "srtnCd") String srtnCd
    ) {
        Dividend dividend = service.selectDividend(userId, bseYm, srtnCd);
        if (dividend == null) {
            throw new CustomException("dividend.search.fail");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dividend);
    }

    @Operation(summary = "배당 내역 적재", description = "배당금을 DB에 적재한다.")
    @GetMapping("/insert")
    @Tag(name = "Dividend")
    public ResponseEntity<Dividend> insertDividend(
            @Parameter(name = "userId", description = "사용자 아이디") @RequestParam(value = "userId") String userId,
            @Parameter(name = "bseYm", description = "기준년월") @RequestParam(value = "bseYm") String bseYm,
            @Parameter(name = "srtnCd", description = "종목코드") @RequestParam(value = "srtnCd") String srtnCd,
            @Parameter(name = "dps", description = "배당금") @RequestParam(value = "dps") double dps,
            @Parameter(name = "payPeriod", description = "지급주기") @RequestParam(value = "payPeriod", required = false) String payPeriod
    ) {
        Dividend dividend = new Dividend();
        dividend.setId(new DividendId(userId,bseYm,srtnCd));
        dividend.setDps(dps);
        dividend.setPayPerd(DividendUtils.getPayPeriod(payPeriod));
        service.insertDiviend(dividend);
        return ResponseEntity.status(HttpStatus.OK).body(dividend);
    }
}
