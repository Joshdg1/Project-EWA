package com.flo4.server.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.lang.reflect.Array;

@Entity
public class Skill {
    @Id
    int Id;

    String name;

    double level;

    @ManyToOne
    @JoinColumn(name = "skill_programmer_id", nullable = false)
    private Programmer programmer;

    public Skill(){};

    public Skill(int programmerId){this.Id = programmerId;}

    public Skill(int id,String name, double level, Programmer programmer) {
        this(id);
        this.name = name;
        this.level = level;
        this.programmer = programmer;
    }


    public int getId() {
        return Id;
    }

    public void setId(int programmerId) {
        this.Id = programmerId;
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

    public Programmer getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }
}
