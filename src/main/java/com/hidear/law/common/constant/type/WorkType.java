package com.hidear.law.common.constant.type;

/**
 * Created by Administrator on 2017/8/28.
 */
public enum WorkType {

    FULL_TIME(1,"全职"),
    PART_TIME(0,"兼职");

    private Integer code;
    private String name;

    WorkType(Integer code,String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String nameOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (WorkType ms : WorkType.values()) {
                if (ms.getCode() == value) {
                    return ms.name();
                }
            }
            return "";
        }
    }
}
