package com.flo4.server.Config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class SecurityConstants {

    public static final long resetExp = 3600000;

    public static String resetToken = "SecretResetKey for this user; refreshSecretKey";

}
