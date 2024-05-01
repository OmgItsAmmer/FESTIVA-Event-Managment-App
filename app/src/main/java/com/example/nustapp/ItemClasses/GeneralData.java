package com.example.nustapp.ItemClasses;

public abstract class GeneralData {

    String eventTitle;

    int imageUrl;

    int interestedOrMembers;

    public GeneralData(String eventTitle, int imageUrl, int interestedOrMembers) {
        this.eventTitle = eventTitle;
        this.imageUrl = imageUrl;
        this.interestedOrMembers = interestedOrMembers;
    }

    public  String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getInterestedOrMembers() {
        return interestedOrMembers;
    }

    public void setInterestedOrMembers(int interestedOrMembers) {
        this.interestedOrMembers = interestedOrMembers;
    }
}
