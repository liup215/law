package com.hidear.law.common.constant.status;

/**
 * Created by Administrator on 2017/7/21.
 */
public enum AreaLevel {

    PREVINCE(1,"province"),
    CITY(2,"city"),
    TOWN(3,"town"),
    COUNTY(4,"county");

    private Integer levelCode;
    private String level;

    AreaLevel() {
    }

    AreaLevel(Integer levelCode, String level) {
        this.levelCode = levelCode;
        this.level = level;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AreaLevel{" +
                "levelCode=" + levelCode +
                ", level='" + level + '\'' +
                '}';
    }

}
