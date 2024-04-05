package com.gp1.gstock.common.kakao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class KakaoService {

    public KakaoToken TokenRequest(String code){
        RestTemplate restTemplate = new RestTemplate();
        //토큰 post 요청
        String url = UriComponentsBuilder
                .fromUriString(KakaoConstants.KAKAO_TOKEN_REQUEST_URI)
                .encode()
                .build()
                .toString();
        KakaoTokenRequestDto requestDto = new KakaoTokenRequestDto(code);

        return restTemplate.postForObject(url,requestDto, KakaoToken.class);
    }
}
