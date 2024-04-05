package com.gp1.gstock.common.kakao;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class KakaoTokenRequestDto {

    private final String grant_type = "authorization_code";
    private final String client_id = KakaoConstants.KAKAO_API_KEY;
    private final String redirect_url = KakaoConstants.KAKAO_REDIRECT_URI_LOCAL;
    @NonNull
    private String code;
    private final String client_secret = KakaoConstants.KAKAO_CLIENT_SECRET_KEY;
}
