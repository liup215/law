package com.hidear.law.modular.transfer;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/10.
 */
public class LoginTF {

    /**
     * 登录方式
     */
    private Integer loginType;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String phoneNumber;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 图片验证码
     */
    private String kaptcha;

    /**
     * 短信验证码
     */
    private String smsCode;

    public LoginTF(Integer loginType, String phoneNumber, String password, String kaptcha, String smsCode) {
        this.loginType = loginType;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.kaptcha = kaptcha;
        this.smsCode = smsCode;
    }

    public LoginTF() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    @Override
    public String toString() {
        return "LoginTF{" +
                "loginType=" + loginType +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", kaptcha='" + kaptcha + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';
    }
}
