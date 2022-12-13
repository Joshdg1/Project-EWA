package com.flo4.server.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserSkills {

    private String skillName;
    private int skillLevel;
    private int userId;

    public GetUserSkills(String skillName, int skillLevel, int userId) {
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.userId = userId;
    }
}
