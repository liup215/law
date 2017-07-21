package com.hidear.law.common.constant.status;

/**
 * Created by Administrator on 2017/7/21.
 */
public enum AreaStatus {
    OK(1,"启用"),DELETED(0,"禁用");

    private Integer status;
    private String message;

    @Override
    public String toString() {
        return "AreaStatus{" +
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

    AreaStatus(Integer status, String message) {

        this.status = status;
        this.message = message;
    }

    AreaStatus() {

    }
}
