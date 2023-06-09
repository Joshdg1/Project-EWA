package com.flo4.server.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

public class Token {
    /**
     * Class to generate a token
     */
    @Getter
    private final String token;

    private Token(String token) {
        this.token = token;
    }

    public static Token of(int userId, Long validity, String secretKey){
        var issueDate = Instant.now();
        return new Token(
                Jwts.builder()
                        .claim("user_id", userId)
                        .setIssuedAt(Date.from(issueDate))
                        .setExpiration(Date.from(issueDate.plus(validity, ChronoUnit.MINUTES)))
                        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8)))
                        .compact());
    }

    public static Token of(String token){
        return new Token(token);
    }

    public static Integer from(String token, String secretKey){
       return ((Claims) Jwts.parserBuilder()
               .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8)))
               .build()
               .parse(token)
               .getBody())
               .get("user_id", Integer.class);
    }
}
