package com.ayuan.douban.vo;

import android.graphics.Bitmap;

public class Images {
    /*private String large;
    private String medium;
    private String small;*/
    private Bitmap large;
    private Bitmap medium;
    private Bitmap small;

    public Images() {
    }

    public Images(Bitmap large, Bitmap medium, Bitmap small) {
        this.large = large;
        this.medium = medium;
        this.small = small;
    }

    public Bitmap getLarge() {
        return large;
    }

    public void setLarge(Bitmap large) {
        this.large = large;
    }

    public Bitmap getMedium() {
        return medium;
    }

    public void setMedium(Bitmap medium) {
        this.medium = medium;
    }

    public Bitmap getSmall() {
        return small;
    }

    public void setSmall(Bitmap small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "Images{" +
                "large=" + large +
                ", medium=" + medium +
                ", small=" + small +
                '}';
    }
}
