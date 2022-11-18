package com.flo4.server.models;

import org.springframework.context.annotation.Primary;

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

}
