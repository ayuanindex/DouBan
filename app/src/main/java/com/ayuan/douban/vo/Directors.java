package com.ayuan.douban.vo;

public class Directors {
    private String alt;
    private Avatars avatars;
    private String id;
    private String name;
    private String neme_en;

    public Directors() {
    }

    public Directors(String alt, Avatars avatars, String id, String name, String neme_en) {
        this.alt = alt;
        this.avatars = avatars;
        this.id = id;
        this.name = name;
        this.neme_en = neme_en;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Avatars getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeme_en() {
        return neme_en;
    }

    public void setNeme_en(String neme_en) {
        this.neme_en = neme_en;
    }

    @Override
    public String toString() {
        return "Directors{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", neme_en='" + neme_en + '\'' +
                '}';
    }
}
