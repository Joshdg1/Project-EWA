package com.flo4.server.service;

import com.flo4.server.models.User;
import lombok.Getter;

public class Login {
    @Getter
    private final int id;
    @Getter
    private final Token accessToken;
    @Getter
    private final Token refreshToken;
    @Getter
    private final User user;

    private static final Long accessTokenValidity = 1L;
    private static final Long refreshTokenValidity = 1440L;

    public Login(int id, Token accessToken, Token refreshToken, User user) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public static Login of(int userId, String accessSecretKey, String refreshSecretKey, User user) {
        return new Login(
                userId, Token.of(userId, accessTokenValidity, accessSecretKey),
                Token.of(userId, refreshTokenValidity, refreshSecretKey),
                user);
    }

    public static Login of(int id, String accessSecret, Token refreshToken, User user) {
        return new Login(
                id, Token.of(id, accessTokenValidity, accessSecret),
                refreshToken,
                user);
    }
}
