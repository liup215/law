package com.hidear.law.modular.home.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.hidear.law.common.constant.status.RegisterStatus;
import com.hidear.law.modular.user.model.User;

/**
 * Created by Administrator on 2017/7/5.
 */
public class RegisterTip {

    private RegisterStatus status;

    private User user;

    public RegisterStatus getStatus() {
        return status;
    }

    public void setStatus(RegisterStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
