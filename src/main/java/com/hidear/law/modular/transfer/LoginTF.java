package com.hidear.law.modular.transfer;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/10.
 */
public class LoginTF {

    @NotBlank(message = "手机号不能为空")
    private String phoneNumber;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码不能为空")
    private String kaptcha;

    public LoginTF(String phoneNumber, String password,String kaptcha) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.kaptcha = kaptcha;
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

    @Override
    public String toString() {
        return "LoginTF{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", kaptcha='" + kaptcha + '\'' +
                '}';
    }
}
