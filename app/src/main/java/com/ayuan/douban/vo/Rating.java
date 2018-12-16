package com.ayuan.douban.vo;

public class Rating {
    private Integer average;
    private Detail details;
    private Integer max;
    private Integer min;
    private Integer stars;

    public Rating() {
    }

    public Rating(Integer average, Detail details, Integer max, Integer min, Integer stars) {
        this.average = average;
        this.details = details;
        this.max = max;
        this.min = min;
        this.stars = stars;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Detail getDetails() {
        return details;
    }

    public void setDetails(Detail details) {
        this.details = details;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "average=" + average +
                ", details=" + details +
                ", max=" + max +
                ", min=" + min +
                ", stars=" + stars +
                '}';
    }
}
