package com.flo4.server.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserSkills {

    private String skillName;
    private double skillLevel;
    private int userId;

    public GetUserSkills(String skillName, double skillLevel, int userId) {
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.userId = userId;
    }
}
