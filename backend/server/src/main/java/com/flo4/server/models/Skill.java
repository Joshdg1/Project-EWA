package com.flo4.server.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.lang.reflect.Array;

@Entity
public class Skill {
    @Id
    int programmerId;

    String name;

    double level;

    @ManyToOne
    @JoinColumn(name = "programmer_id", nullable = false)
    private Programmer programmer;

    public Skill(){};

    public Skill(int programmerId){this.programmerId = programmerId;}

    public Skill(int id,String name, double level, Programmer programmer) {
        this(id);
        this.name = name;
        this.level = level;
        this.programmer = programmer;
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
