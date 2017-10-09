package com.hidear.law.common.constant.status;

/**
 * Created by Administrator on 2017/10/9.
 */
public enum SMSCodeStatus {
    USED(1,"已使用"),UNUSED(0,"未使用");

    private Integer status;
    private String message;

    @Override
    public String toString() {
        return "SMSCodeStatus{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
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

    SMSCodeStatus(Integer status, String message){
        this.status = status;
        this.message = message;
    }
}
