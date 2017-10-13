package com.hidear.law.common.constant.type;

/**
 * Created by Administrator on 2017/10/13.
 */
public enum LoginType {

    SMS_CODE(0,"短信验证码登录"),USERNAME_PASSWORD(1,"账号密码登录");

    Integer type;
    String name;

    LoginType(Integer type,String name){
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
