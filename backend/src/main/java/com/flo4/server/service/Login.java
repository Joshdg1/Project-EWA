package com.flo4.server.service;

import lombok.Getter;

public class Login {
    @Getter
    private final int id;
    @Getter
    private final Token accessToken;
    @Getter
    private final Token refreshToken;

    private static final Long accessTokenValidity = 1L;
    private static final Long refreshTokenValidity = 1440L;

    public Login(int id, Token accessToken, Token refreshToken) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static Login of(int userId, String accessSecretKey, String refreshSecretKey){
         return new Login(
                 userId, Token.of(userId, accessTokenValidity, accessSecretKey),
                Token.of(userId, refreshTokenValidity, refreshSecretKey)
        );
    }

    public static Login of(int id, String accessSecret, Token refreshToken){
        return new Login(
                id, Token.of(id, accessTokenValidity, accessSecret),
                refreshToken
        );
    }
}