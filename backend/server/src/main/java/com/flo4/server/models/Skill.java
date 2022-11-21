package com.flo4.server.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;

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
    public static Skill creatRandomSkill(int programmerId){
        String [] names = {"Rust", "Dart", "Flutter", "C#", "Java"};
        Skill skill = new Skill(programmerId);
        skill.setName(names[(int) Math.round(Math.random()*5)]);
        skill.setLevel(Math.round(Math.random()*5));
        return skill;
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
