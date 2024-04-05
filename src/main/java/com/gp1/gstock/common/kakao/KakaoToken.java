package com.gp1.gstock.common.kakao;

import lombok.Data;

@Data
public class KakaoToken {
    private String token_type;
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String refresh_token_expires_in;
    private String scope;
}
