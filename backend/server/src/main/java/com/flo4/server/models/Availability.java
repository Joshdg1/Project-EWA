package com.flo4.server.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Availability {


    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    public Availability(){}

    public Availability(long id){this.id = id;}

    public Availability(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
