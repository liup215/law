package com.hidear.law.modular.transfer;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Test1 {
    public Integer bb;
    public Integer cc;

    public Integer getBb() {
        return bb;
    }

    public void setBb(Integer bb) {
        this.bb = bb;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "b=" + bb +
                ", c=" + cc +
                '}';
    }
}
