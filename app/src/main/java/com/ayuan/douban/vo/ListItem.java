package com.ayuan.douban.vo;

import android.graphics.Bitmap;

public class ListItem extends Subjects {
    private Bitmap bitmap;
    private String moveName;

    public ListItem() {
    }

    public ListItem(Bitmap bitmap, String moveName) {
        this.bitmap = bitmap;
        this.moveName = moveName;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "bitmap=" + bitmap +
                ", moveName='" + moveName + '\'' +
                '}';
    }
}
