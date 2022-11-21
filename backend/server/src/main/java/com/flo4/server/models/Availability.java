package com.flo4.server.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Availability {

    @Id
    private Long programmerId;

    private LocalDate startDate;

    private LocalDate endDate;

    public Availability(){}

    public Availability(long programmerId){this.programmerId = programmerId;}

    public Availability(Long programmerId, LocalDate startDate, LocalDate endDate) {
        this.programmerId = programmerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(Long id) {
        this.programmerId = programmerId;
    }


    public Long getId() {
        return programmerId;
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
