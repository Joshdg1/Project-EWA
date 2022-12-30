package com.flo4.server.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mail {
    private String to;
    private String code;
}
