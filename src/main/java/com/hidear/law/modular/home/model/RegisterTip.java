package com.hidear.law.modular.home.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.hidear.law.modular.user.model.User;

/**
 * Created by Administrator on 2017/7/5.
 */
public class RegisterTip {
    private String status;

    private String code;

    private String message;

    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
