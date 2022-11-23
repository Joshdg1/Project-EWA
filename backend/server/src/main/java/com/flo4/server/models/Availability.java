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
    private Long Id;

    private LocalDate startDate;

    private LocalDate endDate;

    public Availability(){}

    public Availability(long Id){this.Id = Id;}

    public Availability(Long Id, LocalDate startDate, LocalDate endDate) {
        this.Id = Id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }


    public Long getId() {
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
