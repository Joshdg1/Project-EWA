package com.flo4.server.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class UserAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public UserAvailability(){}

    public UserAvailability(int Id){this.Id = Id;}

    public UserAvailability(int Id, LocalDateTime startDate, LocalDateTime endDate) {
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
