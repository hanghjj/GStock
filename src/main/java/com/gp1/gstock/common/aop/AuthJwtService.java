package com.gp1.gstock.common.aop;

import com.gp1.gstock.common.constants.BizConstants;
import io.jsonwebtoken.Jwts;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthJwtService {

    public String getToken(String id) {
        String issuer = BizConstants.PROJECT_NAME;
        String subject = "Auth";
        Date expiredAt = Date.from(Instant.now().plus(Duration.ofHours(2L)));
        Date notBeforeAt = Date.from(Instant.now());
        Date issuedAt = Date.from(Instant.now());
        String jwtId = UUID.randomUUID().toString();
        SecretKey key = Jwts.SIG.HS256.key().build();

        return Jwts.builder()
                .issuer(issuer)
                .subject(subject)
                .expiration(expiredAt)
                .notBefore(notBeforeAt)
                .issuedAt(issuedAt)
                .id(jwtId)
                .signWith(key)
                .compact();
    }
}
