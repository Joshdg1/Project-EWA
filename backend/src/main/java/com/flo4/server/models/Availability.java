package com.flo4.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private LocalDate startDate;

    private LocalDate endDate;

    public Availability(){}

    public Availability(int Id){this.Id = Id;}

    public Availability(int Id, LocalDate startDate, LocalDate endDate) {
        this.Id = Id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    public int getId() {
        return Id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
