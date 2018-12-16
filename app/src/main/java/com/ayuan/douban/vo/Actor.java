package com.ayuan.douban.vo;

public class Actor {
    private String alt;
    private Avatars avatars;
    private String id;
    private String name;
    private String name_en;

    public Actor() {
    }

    public Actor(String alt, Avatars avatars, String id, String name, String name_en) {
        this.alt = alt;
        this.avatars = avatars;
        this.id = id;
        this.name = name;
        this.name_en = name_en;
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

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                '}';
    }
}
