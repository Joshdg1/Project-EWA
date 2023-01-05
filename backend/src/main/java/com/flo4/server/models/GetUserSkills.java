package com.flo4.server.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserSkills {
    private String name;
    private double level;
    private int user_id;


    public GetUserSkills(String name, double level, int user_id) {
        this.name = name;
        this.level = level;
        this.user_id = user_id;
    }
}
