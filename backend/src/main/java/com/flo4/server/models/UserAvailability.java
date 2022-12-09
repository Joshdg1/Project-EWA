package com.flo4.server.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UserAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    public UserAvailability(){}

    public UserAvailability(int id){this.id = id;}

    public UserAvailability(int id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
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
