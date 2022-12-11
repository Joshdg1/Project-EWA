package com.flo4.server.service;

import lombok.Getter;

public class Login {
    @Getter
    private final Token accessToken;
    @Getter
    private final Token refreshToken;

    public Login(Token accessToken, Token refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static Login of(int userId, String accessSecretKey, String refreshSecretKey){
         return new Login(
                Token.of(userId, 1L, accessSecretKey),
                Token.of(userId, 1440L, refreshSecretKey)
        );
    }

    public static Login of(int id, String accessSecret, Token refreshToken){
        return new Login(
                Token.of(id, 1L, accessSecret),
                refreshToken
        );
    }
}
