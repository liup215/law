package com.hidear.law.modular.User.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
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
    private Integer id;

    /**
     * 账号，初期和电话号相同
     */
    @Column(name="username",nullable = false,length = 75)
    private String username;
    /**
     * 昵称
     */
    @Column(name="nickname",nullable = true,length=75)
    private String nickname;
    /**
     * 密码
     */
    @Column(name="password",nullable = true,length = 75)
    private String password;
    /**
     * 手机号
     */
    @Column(name="phoneNumber",nullable=false,length=75)
    private String phoneNumber;
    /**
     * 电子邮件
     */
    @Column(name="email",nullable=true,length=45)
    private String email;
    /**
     * 真实姓名
     */
    @Column(name="truename",nullable = true,length = 30)
    private String truename;
    /**
     * 所在地区
     */
    @Column(name="area",nullable = true,length = 55)
    private String area;
    /**
     * 详细地址
     */
    @Column(name="detailAddress",nullable = true,length = 55)
    private String detailAddress;
    /**
     * 用户类型
     */
    @Column(name="userType",nullable = true,length=15)
    private String userType;
    /**
     * 头像
     */
    @Column(name="avatar",nullable = true,length = 75)
    private String avatar;
    /**
     * 注册时间
     */
    @Column(name="registerTime",nullable = false,length = 75)
    private Long registerTime;
    /**
     * 上次登录时间
     */
    @Column(name="lastLoginTime",nullable = true,length = 75)
    private Long lastLoginTime;
    /**
     * 金币数
     */
    @Column(name="coin",nullable = false,length = 10)
    private Double coin;
    /**
     * 状态
     */
    @Column(name="status",nullable = false,length = 10)
    private Integer status;
    /**
     * 盐
     */
    @Column(name="salt",nullable=false,length = 45)
    private String salt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Double getCoin() {
        return coin;
    }

    public void setCoin(Double coinNum) {
        this.coin = coinNum;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
