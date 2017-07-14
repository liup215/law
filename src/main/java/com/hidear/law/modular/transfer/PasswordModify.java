package com.hidear.law.modular.transfer;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2017/7/14.
 */
public class PasswordModify {

    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    @NotBlank(message = "原密码不能为空")
    @Size(min=6,max=8,message = "密码为6~8位的字母、数字、符号组成")
    private String newPassword;

    @NotBlank
    @Size(min=6,max=8,message = "密码为6~8位的字母、数字、符号组成")
    private String passwordConfirm;

    @Override
    public String toString() {
        return "PasswordModify{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public PasswordModify(String oldPassword, String newPassword, String passwordConfirm) {

        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.passwordConfirm = passwordConfirm;
    }

    public PasswordModify() {

    }
}
