package com.flo4.server.service;

import lombok.Getter;

public class Login {
    @Getter
    private final int Id;
    @Getter
    private final Token accessToken;
    @Getter
    private final Token refreshToken;

    private static final Long accessTokenValidity = 1L;
    private static final Long refreshTokenValidity = 1440L;

    public Login(int Id, Token accessToken, Token refreshToken) {
        this.Id = Id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static Login of(int userId, String accessSecretKey, String refreshSecretKey){
         return new Login(
                 userId, Token.of(userId, accessTokenValidity, accessSecretKey),
                Token.of(userId, refreshTokenValidity, refreshSecretKey)
        );
    }

    public static Login of(int Id, String accessSecret, Token refreshToken){
        return new Login(
                Id, Token.of(Id, accessTokenValidity, accessSecret),
                refreshToken
        );
    }
}
