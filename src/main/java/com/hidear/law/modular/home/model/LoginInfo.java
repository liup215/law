package com.hidear.law.modular.home.model;

/**
 * Created by Administrator on 2017/7/7.
 */
public class LoginInfo {
    private String username;
    private String password;
    private String kaptcha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKaptcha() {
        return kaptcha;
    }

    public void setKaptcha(String kaptcha) {
        this.kaptcha = kaptcha;
    }
}
