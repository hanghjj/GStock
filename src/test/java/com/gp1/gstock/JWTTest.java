package com.gp1.gstock;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
public class JWTTest {


    @Test
    @DisplayName("JWT 생성 확인")
    void creationTest() {
        //given
        String issuer = "GH";
        String subject = "Auth";
        String audience = "GH";
        Date expiredAt = Date.from(Instant.now().plus(Duration.ofDays(1L)));
        Date NotBeforeAt = Date.from(Instant.now());
        Date issuedAt = Date.from(Instant.now());
        String jwtId = UUID.randomUUID().toString();

        // when
        SecretKey key = Keys
                .secretKeyFor(SignatureAlgorithm.HS256);
        //then
        var jws = Jwts
                .builder()
                .issuer(issuer)
                .subject(subject)
                .setAudience(audience)
                .setExpiration(expiredAt)
                .setNotBefore(NotBeforeAt)
                .setIssuedAt(issuedAt)
                .setId(jwtId)
                .signWith(key)
                .compact();

        System.out.println(jws);
    }
}
