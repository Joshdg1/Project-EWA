package com.flo4.server.models;


import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    String name;

    double level;

    @ManyToOne
    @JoinColumn(name = "skill_programmer_id", nullable = true)
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
