package com.example.nustapp.ItemClasses;

public class SeeAllSocietiesItemData {

    String societyName;

    int bannerURl;

    int HiringUrl;

    public SeeAllSocietiesItemData(String societyName, int bannerURl, int hiringUrl) {
        this.societyName = societyName;
        this.bannerURl = bannerURl;
        HiringUrl = hiringUrl;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public int getBannerURl() {
        return bannerURl;
    }

    public void setBannerURl(int bannerURl) {
        this.bannerURl = bannerURl;
    }

    public int getHiringUrl() {
        return HiringUrl;
    }

    public void setHiringUrl(int hiringUrl) {
        HiringUrl = hiringUrl;
    }
}
