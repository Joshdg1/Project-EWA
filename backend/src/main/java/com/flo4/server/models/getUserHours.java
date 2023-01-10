package com.flo4.server.models;

public class getUserHours {

    double hours;

    private int userID;

    private Project project;

    private String isApproved;

    public getUserHours(double hours, int userID, Project project, String isApproved) {
        this.hours = hours;
        this.userID = userID;
        this.project = project;
        this.isApproved = isApproved;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }
}
