package com.ayuan.douban.vo;

import android.graphics.Bitmap;

public class Images {
    private String large;
    private String medium;
    private String small;
    /*private Bitmap large;
    private Bitmap medium;
    private Bitmap small;*/

    public Images() {
    }

    public Images(String large, String medium, String small) {
        this.large = large;
        this.medium = medium;
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "Images{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", small='" + small + '\'' +
                '}';
    }
}
