package com.hidear.law.modular.user.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acer on 2017/7/2.
 */
@Entity
@Table(name="lw_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length=45)
    private Long id;

    @Column(name="username",nullable = false,length = 75)
    private String username;

    @Column(name="nickname",nullable = true,length=75)
    private String nickname;

    @Column(name="password",nullable = true,length = 75)
    private String password;

    @Column(name="phoneNumber",nullable=false,length=75)
    private String phoneNumber;

    @Column(name="email",nullable=true,length=45)
    private String email;

    @Column(name="truename",nullable = true,length = 30)
    private String truename;

    @Column(name="area",nullable = true,length = 55)
    private String area;

    @Column(name="detailAddress",nullable = true,length = 55)
    private String detailAddress;

    @Column(name="userType",nullable = true,length=15)
    private Long userType;

    @Column(name="avatar",nullable = true,length = 75)
    private String avatar;

    @Column(name="registerTime",nullable = false)
    private Date registerTime;

    @Column(name="lastLoginTime",nullable = true)
    private Date lastLoginTime;

    @Column(name="coinNum",nullable = false,length = 10)
    private Double coinNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoblilePhone() {
        return phoneNumber;
    }

    public void setMoblilePhone(String moblilePhone) {
        this.phoneNumber = moblilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Double getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Double coinNum) {
        this.coinNum = coinNum;
    }
}
