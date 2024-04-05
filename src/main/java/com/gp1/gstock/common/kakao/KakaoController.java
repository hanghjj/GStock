package com.gp1.gstock.common.kakao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("api/kakao")
@Tag(name = "KAKAO", description = "카카오 로그인 관련 API")
@AllArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/oauth")
    @Tag(name = "KAKAO")
    @Operation(summary = "카카오 OAuth 요청 Redirect", description = "Redirect 후 수신")
    public ResponseEntity<KakaoToken> getSocialLogin(
            @Parameter(name = "code", description = "OAuth 인가코드") @RequestParam(name = "code") String code
    ){
        KakaoToken token = kakaoService.TokenRequest(code);
        if(!ObjectUtils.isEmpty(token)) return ResponseEntity.ok(token);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
