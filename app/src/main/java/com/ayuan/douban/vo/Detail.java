package com.ayuan.douban.vo;

public class Detail {
    private Integer _1;
    private Integer _2;
    private Integer _3;
    private Integer _4;
    private Integer _5;

    public Detail() {
    }

    public Detail(Integer _1, Integer _2, Integer _3, Integer _4, Integer _5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
    }

    public Integer get_1() {
        return _1;
    }

    public void set_1(Integer _1) {
        this._1 = _1;
    }

    public Integer get_2() {
        return _2;
    }

    public void set_2(Integer _2) {
        this._2 = _2;
    }

    public Integer get_3() {
        return _3;
    }

    public void set_3(Integer _3) {
        this._3 = _3;
    }

    public Integer get_4() {
        return _4;
    }

    public void set_4(Integer _4) {
        this._4 = _4;
    }

    public Integer get_5() {
        return _5;
    }

    public void set_5(Integer _5) {
        this._5 = _5;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                ", _4=" + _4 +
                ", _5=" + _5 +
                '}';
    }
}
