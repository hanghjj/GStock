package com.gp1.gstock.common.kakao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoOauthResponseDto {
    private String code;
    private String error;
    private String error_description;
    private String state;
}
