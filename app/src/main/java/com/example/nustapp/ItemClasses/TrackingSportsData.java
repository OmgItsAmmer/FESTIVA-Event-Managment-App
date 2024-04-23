package com.example.nustapp.ItemClasses;

public class TrackingSportsData {

    String item1Title;
    String item2Title;
    int item1ImageUrl;
    int item2ImageUrl;

    public TrackingSportsData() {
    }

    public TrackingSportsData(String item1Title, String item2Title, int item1ImageUrl, int item2ImageUrl) {
        this.item1Title = item1Title;
        this.item2Title = item2Title;
        this.item1ImageUrl = item1ImageUrl;
        this.item2ImageUrl = item2ImageUrl;
    }

    public String getItem1Title() {
        return item1Title;
    }

    public void setItem1Title(String item1Title) {
        this.item1Title = item1Title;
    }

    public String getItem2Title() {
        return item2Title;
    }

    public void setItem2Title(String item2Title) {
        this.item2Title = item2Title;
    }

    public int getItem1ImageUrl() {
        return item1ImageUrl;
    }

    public void setItem1ImageUrl(int item1ImageUrl) {
        this.item1ImageUrl = item1ImageUrl;
    }

    public int getItem2ImageUrl() {
        return item2ImageUrl;
    }

    public void setItem2ImageUrl(int item2ImageUrl) {
        this.item2ImageUrl = item2ImageUrl;
    }


}
