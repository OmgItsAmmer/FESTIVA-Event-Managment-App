package com.example.nustapp.ItemClasses;

public class EventBannerData {

    String eventTitle;
    int bannerUrl;

    public boolean isExpandable = false;

    int intresetedNo;

    String Eventdesription;

    public EventBannerData(String eventTitle, int bannerUrl, boolean isExpandable, int intresetedNo, String eventdesription) {

        this.eventTitle = eventTitle;
        this.bannerUrl = bannerUrl;
        this.isExpandable = isExpandable;
        this.intresetedNo = intresetedNo;
        Eventdesription = eventdesription;
    }

    public EventBannerData() {
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(int bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public int getIntresetedNo() {
        return intresetedNo;
    }

    public void setIntresetedNo(int intresetedNo) {
        this.intresetedNo = intresetedNo;
    }

    public String getEventdesription() {
        return Eventdesription;
    }

    public void setEventdesription(String eventdesription) {
        Eventdesription = eventdesription;
    }
}
