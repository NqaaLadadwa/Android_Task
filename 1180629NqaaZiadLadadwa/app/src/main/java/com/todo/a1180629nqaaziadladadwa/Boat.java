package com.todo.a1180629nqaaziadladadwa;


public class Boat {
    public int mBoatId ;
    private String mBoatName;
    private String mColor;

    public Boat() {
    }

    public Boat(int mBoatId, String mBoatName, String mColor) {
        this.mBoatId = mBoatId;
        this.mBoatName = mBoatName;
        this.mColor = mColor;

    }

    public Boat(int mBoatId) {
    }


    public String getmBoatName() {
        return mBoatName;
    }

    public void setmBoatName(String mBoatName) {
        this.mBoatName = mBoatName;
    }

    public String getmColor() {
        return mColor;
    }

    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "mBoatId=" + mBoatId +
                ", mBoatName='" + mBoatName + '\'' +
                ", mColor='" + mColor + '\'' +
                '}';
    }
}
