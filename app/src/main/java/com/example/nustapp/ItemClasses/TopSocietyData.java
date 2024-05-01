package com.example.nustapp.ItemClasses;

public class TopSocietyData extends GeneralData{

    int hiringUrl;

    boolean hiringflag;


    public TopSocietyData(String eventTitle, int imageUrl, int interestedOrMembers, int hiringUrl, boolean hiringflag) {
        super(eventTitle, imageUrl, interestedOrMembers);
        this.hiringUrl = hiringUrl;
        this.hiringflag = hiringflag;
    }

    public int getHiringUrl() {
        return hiringUrl;
    }

    public void setHiringUrl(int hiringUrl) {
        this.hiringUrl = hiringUrl;
    }

    public boolean isHiringflag() {
        return hiringflag;
    }

    public void setHiringflag(boolean hiringflag) {
        this.hiringflag = hiringflag;
    }
}
