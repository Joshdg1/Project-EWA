package com.flo4.server.utils;


import com.flo4.server.Config.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

public class PasswordResetUtil {
    public String generateResetToken(String id){
        String token = Jwts.builder()
                .setSubject(id)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.resetExp))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(SecurityConstants.resetToken.getBytes(StandardCharsets.UTF_8)))
                .compact();
        return token;
    }
}
