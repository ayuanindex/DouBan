package com.ayuan.douban.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class Subjects {
    private String alt;
    private ArrayList<Actor> actor;
    private Integer collect_count;
    private ArrayList<Directors> directors;
    private ArrayList<String> durations;
    private ArrayList<String> genres;
    private boolean has_video;
    private String id;
    private Images images;
    private String mainland_pubdate;
    private String original_title;
    private ArrayList<String> pubdates;
    private Rating rating;
    private String subtype;
    private String title;
    private String year;
    private String titles;
    private Integer total;

    public Subjects() {
    }

    public Subjects(String alt, ArrayList<Actor> actor, Integer collect_count, ArrayList<Directors> directors, ArrayList<String> durations, ArrayList<String> genres, boolean has_video, String id, Images images, String mainland_pubdate, String original_title, ArrayList<String> pubdates, Rating rating, String subtype, String title, String year, String titles, Integer total) {
        this.alt = alt;
        this.actor = actor;
        this.collect_count = collect_count;
        this.directors = directors;
        this.durations = durations;
        this.genres = genres;
        this.has_video = has_video;
        this.id = id;
        this.images = images;
        this.mainland_pubdate = mainland_pubdate;
        this.original_title = original_title;
        this.pubdates = pubdates;
        this.rating = rating;
        this.subtype = subtype;
        this.title = title;
        this.year = year;
        this.titles = titles;
        this.total = total;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public ArrayList<Actor> getActor() {
        return actor;
    }

    public void setActor(ArrayList<Actor> actor) {
        this.actor = actor;
    }

    public Integer getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(Integer collect_count) {
        this.collect_count = collect_count;
    }

    public ArrayList<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Directors> directors) {
        this.directors = directors;
    }

    public ArrayList<String> getDurations() {
        return durations;
    }

    public void setDurations(ArrayList<String> durations) {
        this.durations = durations;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public ArrayList<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(ArrayList<String> pubdates) {
        this.pubdates = pubdates;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getActors() {
        if (actor.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("演员:");
        for (Actor actor1 : actor) {
            stringBuffer.append("/" + actor1.getName());
        }
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "alt='" + alt + '\'' +
                ", actor=" + actor +
                ", collect_count=" + collect_count +
                ", directors=" + directors +
                ", durations=" + durations +
                ", genres=" + genres +
                ", has_video=" + has_video +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", mainland_pubdate='" + mainland_pubdate + '\'' +
                ", original_title='" + original_title + '\'' +
                ", pubdates=" + pubdates +
                ", rating=" + rating +
                ", subtype='" + subtype + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", titles='" + titles + '\'' +
                ", total=" + total +
                '}';
    }
}
