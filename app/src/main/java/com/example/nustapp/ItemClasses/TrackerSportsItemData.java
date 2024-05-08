package com.example.nustapp.ItemClasses;

public class TrackerSportsItemData {

    private String groundName;

    private String status;

    private Boolean availability;

     public Boolean isExpandable;

    public TrackerSportsItemData(String groundName, String status, Boolean availability,Boolean isExpandable) {
        this.setGroundName(groundName);
        this.setStatus(status);
        this.setAvailability(availability);
        this.isExpandable = isExpandable;
    }

    public Boolean getExpandable() {
        return isExpandable;
    }

    public void setExpandable(Boolean expandable) {
        isExpandable = expandable;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
