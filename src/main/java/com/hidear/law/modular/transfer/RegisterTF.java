package com.hidear.law.modular.transfer;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2017/7/10.
 */
public class RegisterTF {

    @NotBlank(message = "电话号码不能为空")
    private String phoneNumber;

    @NotBlank(message = "短信验证码不能为空")
    private String smsCode;

    @NotBlank(message = "密码不能为空")
    @Size(min=6,max=8)
    private String password;

    @NotBlank(message = "密码确认不能为空")
    @Size(min=6,max=8,message = "密码长度为6-8位")
    private String passwordConfirm;

    public RegisterTF() {
    }

    public RegisterTF(String phoneNumber, String smsCode, String password, String passwordConfirm) {
        this.phoneNumber = phoneNumber;
        this.smsCode = smsCode;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String verifyCode) {
        this.smsCode = smsCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return "RegisterTF{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", verifyCode='" + smsCode + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}
