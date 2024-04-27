package com.example.nustapp.ItemClasses;

public class MembershipItemData {
    private String membersshipEventTitle;
   private int membersshipBannerUrl;

   private  boolean membersshipIsExpandable = false;

   private int membersshipNo;



    public String getMembersshipEventTitle() {
        return membersshipEventTitle;
    }

    public void setMembersshipEventTitle(String membersshipEventTitle) {
        this.membersshipEventTitle = membersshipEventTitle;
    }

    public int getMembersshipBannerUrl() {
        return membersshipBannerUrl;
    }

    public void setMembersshipBannerUrl(int membersshipBannerUrl) {
        this.membersshipBannerUrl = membersshipBannerUrl;
    }

    public boolean isMembersshipIsExpandable() {
        return membersshipIsExpandable;
    }

    public void setMembersshipIsExpandable(boolean membersshipIsExpandable) {
        this.membersshipIsExpandable = membersshipIsExpandable;
    }

    public int getMembersshipNo() {
        return membersshipNo;
    }

    public void setMembersshipNo(int membersshipNo) {
        this.membersshipNo = membersshipNo;
    }



    public MembershipItemData(String membersshipEventTitle, int membersshipBannerUrl, boolean membersshipIsExpandable, int membersshipNo) {
        this.membersshipEventTitle = membersshipEventTitle;
        this.membersshipBannerUrl = membersshipBannerUrl;
        this.membersshipIsExpandable = membersshipIsExpandable;
        this.membersshipNo = membersshipNo;



    }
}
