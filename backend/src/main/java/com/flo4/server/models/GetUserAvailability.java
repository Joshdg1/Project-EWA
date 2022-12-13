package com.flo4.server.models;

import java.time.LocalDateTime;

public class GetUserAvailability {

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int userId;

    public GetUserAvailability(String title, LocalDateTime startDate, LocalDateTime endDate, int userId) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
