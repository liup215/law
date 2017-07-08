package com.hidear.law.common.constant.status;

/**
 * Created by Administrator on 2017/7/8.
 */
public enum RegisterStatus {

    SUCCESS(200,"注册成功"),
    WRONG_VERIFY(201,"验证码错误"),
    WRONG_PASSWORD_CONFIRM(202,"两次输入密码不同"),
    DUPLICTED_PHONE(203,"手机号或用户名已存在"),
    DUPLICTED_USERNAME(204,"用户名已存在");


    private Integer status;
    private String message;

    RegisterStatus(Integer status,String message){
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
