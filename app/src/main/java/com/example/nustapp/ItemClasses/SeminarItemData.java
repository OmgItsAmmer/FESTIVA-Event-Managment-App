package com.example.nustapp.ItemClasses;

public class SeminarItemData extends GeneralData{

    String authorName;

    int bannerColor;

    int proflePic;

    String timingSeminar;

    String seminarAddress;


    public SeminarItemData(String eventTitle, int imageUrl, int interestedOrMembers, String authorName, int bannerColor, int proflePic, String timingSeminar, String seminarAddress) {
        super(eventTitle, imageUrl, interestedOrMembers);
        this.authorName = authorName;
        this.bannerColor = bannerColor;
        this.proflePic = proflePic;
        this.timingSeminar = timingSeminar;
        this.seminarAddress = seminarAddress;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBannerColor() {
        return bannerColor;
    }

    public void setBannerColor(int bannerColor) {
        this.bannerColor = bannerColor;
    }

    public int getProflePic() {
        return proflePic;
    }

    public void setProflePic(int proflePic) {
        this.proflePic = proflePic;
    }

    public String getTimingSeminar() {
        return timingSeminar;
    }

    public void setTimingSeminar(String timingSeminar) {
        this.timingSeminar = timingSeminar;
    }

    public String getSeminarAddress() {
        return seminarAddress;
    }

    public void setSeminarAddress(String seminarAddress) {
        this.seminarAddress = seminarAddress;
    }
}
