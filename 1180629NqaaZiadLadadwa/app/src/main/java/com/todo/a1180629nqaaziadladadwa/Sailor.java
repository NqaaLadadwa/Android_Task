package com.todo.a1180629nqaaziadladadwa;

public class Sailor{
    private int mSailorId ;
    private String mSailorName;
    private String mNationality;
    private int mBoatId;


    public Sailor(int mSailorId, String mSailorName, String mNationality,int mBoatId) {
        this.mSailorId = mSailorId;
        this.mSailorName = mSailorName;
        this.mNationality = mNationality;
        this.mBoatId = mBoatId;
    }

    public Sailor() {

    }

    public int getmBoatId() {
        return mBoatId;
    }

    public void setmBoatId(int mBoatId) {
        this.mBoatId = mBoatId;
    }

    public int getmSailorId() {
        return mSailorId;
    }

    public void setmSailorId(int mSailorId) {
        this.mSailorId = mSailorId;
    }

    public String getmSailorName() {
        return mSailorName;
    }

    public void setmSailorName(String mSailorName) {
        this.mSailorName = mSailorName;
    }

    public String getmNationality() {
        return mNationality;
    }

    public void setmNationality(String mNationality) {
        this.mNationality = mNationality;
    }

    @Override
    public String toString() {
        return "Sailor{" +
                "mBoatId=" + mBoatId +
                ", mSailorId=" + mSailorId +
                ", mSailorName='" + mSailorName + '\'' +
                ", mNationality='" + mNationality + '\'' +
                '}';
    }
}
