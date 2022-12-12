package com.flo4.server.models;

import java.time.LocalDateTime;

public class GetUserAvailability {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int userId;

    public GetUserAvailability(LocalDateTime startDate, LocalDateTime endDate, int userId) {
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
}
