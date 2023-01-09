package com.flo4.server.service;

import com.flo4.server.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordReset {
    private String email;
}
