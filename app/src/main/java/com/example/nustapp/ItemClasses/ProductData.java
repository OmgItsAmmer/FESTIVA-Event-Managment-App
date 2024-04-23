package com.example.nustapp.ItemClasses;


public class ProductData {

    String item1title;
    String item2title;

    int firstImageUrl;

    int secondImageUrl;

    Boolean item1lightStatus;
    Boolean item2lightStatus;


    public ProductData(String item1title, String item2title, int firstImageUrl, int secondImageUrl, Boolean item1lightStatus, Boolean item2lightStatus) {
        this.item1title = item1title;
        this.item2title = item2title;
        this.firstImageUrl = firstImageUrl;
        this.secondImageUrl = secondImageUrl;
        this.item1lightStatus = item1lightStatus;
        this.item2lightStatus = item2lightStatus;
    }

    public String getItem1title() {
        return item1title;
    }

    public void setItem1title(String item1title) {
        this.item1title = item1title;
    }

    public String getItem2title() {
        return item2title;
    }

    public void setItem2title(String item2title) {
        this.item2title = item2title;
    }

    public int getFirstImageUrl() {
        return firstImageUrl;
    }

    public void setFirstImageUrl(int firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
    }

    public int getSecondImageUrl() {
        return secondImageUrl;
    }

    public void setSecondImageUrl(int secondImageUrl) {
        this.secondImageUrl = secondImageUrl;
    }

    public Boolean getItem1lightStatus() {
        return item1lightStatus;
    }

    public void setItem1lightStatus(Boolean item1lightStatus) {
        this.item1lightStatus = item1lightStatus;
    }

    public Boolean getItem2lightStatus() {
        return item2lightStatus;
    }

    public void setItem2lightStatus(Boolean item2lightStatus) {
        this.item2lightStatus = item2lightStatus;
    }






    public ProductData() {
    }


}
