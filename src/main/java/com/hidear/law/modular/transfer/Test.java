package com.hidear.law.modular.transfer;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Test {
    public String a;
    public Test1 b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Test1 getB() {
        return b;
    }

    public void setB(Test1 b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a='" + a + '\'' +
                ", b=" + b.toString() +
                '}';
    }
}
