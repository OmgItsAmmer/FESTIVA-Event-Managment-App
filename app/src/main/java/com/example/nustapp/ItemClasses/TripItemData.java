package com.example.nustapp.ItemClasses;

public class TripItemData  {

    String tripTitle;

    String TripDate;

    String validTripDate;

    String tripBy;

    int imageUrl;

    public TripItemData(String tripTitle, String tripDate, String validTripDate, String tripBy, int imageUrl) {
        this.tripTitle = tripTitle;
        TripDate = tripDate;
        this.validTripDate = validTripDate;
        this.tripBy = tripBy;
        this.imageUrl = imageUrl;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

    public String getTripDate() {
        return TripDate;
    }

    public void setTripDate(String tripDate) {
        TripDate = tripDate;
    }

    public String getValidTripDate() {
        return validTripDate;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setValidTripDate(String validTripDate) {
        this.validTripDate = validTripDate;
    }

    public String getTripBy() {
        return tripBy;
    }

    public void setTripBy(String tripBy) {
        this.tripBy = tripBy;
    }
}
