package com.flo4.server.service;

import java.util.UUID;


public class UserCode {
    public static String getCode(){
        return UUID.randomUUID().toString();
    }
}
