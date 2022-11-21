package com.flo4.server.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Skill {
    @Id
    int programmerId;

    String name;

    double level;

    public Skill(){};

    public Skill(int programmerId){this.programmerId = programmerId;}

    public Skill(int id,String name, double level) {
        this(id);
        this.name = name;
        this.level = level;
    }

    public int getProgrammerId() {
        return programmerId;
    }

    public void setProgrammerId(int programmerId) {
        this.programmerId = programmerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
