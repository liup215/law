package com.hidear.law.common.constant.type;

/**
 * Created by Administrator on 2017/10/11.
 */
public enum SMSType {
    //短信类型唯一性标识:1,短信验证码;
    VerifyCode(1,"短信验证码");

    String name;
    Integer type;

    SMSType(Integer type,String name){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
