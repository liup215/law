package com.hidear.law.modular.admin.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/1.
 */

@Entity
@Table(name="lw_admin_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 11)
    private Integer id;
    /**
     * 头像
     */
    @Column(name = "avatar",nullable = false,length = 255)
    private String avatar;
    /**
     * 账号
     */
    @Column(name = "account",nullable = false,length = 45)
    private String account;
    /**
     * 密码
     */
    @Column(name = "password",nullable = false,length = 45)
    private String password;
    /**
     * md5密码盐
     */
    @Column(name = "salt",nullable = false,length = 45)
    private String salt;
    /**
     * 名字
     */
    @Column(name = "name",nullable = false,length = 45)
    private String name;
    /**
     * 生日
     */
    @Column(name = "birthday",nullable = false)
    private Date birthday;
    /**
     * 性别（1：男 2：女）
     */
    @Column(name = "sex",nullable = false,length = 11)
    private Integer sex;
    /**
     * 电子邮件
     */
    @Column(name = "email",nullable = false,length = 45)
    private String email;
    /**
     * 电话
     */
    @Column(name = "phone",nullable = false,length = 45)
    private String phone;
    /**
     * 角色id
     */
    @Column(name = "roleid",nullable = false,length = 255)
    private Integer roleid;
    /**
     * 部门id
     */
    @Column(name = "deptid",nullable = false,length = 11)
    private Integer deptid;
    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    @Column(name = "status",nullable = false,length = 11)
    private Integer status;
    /**
     * 创建时间
     */
    @Column(name = "createtime",nullable = false)
    private Date createtime;
    /**
     * 保留字段
     */
    @Column(name = "version",nullable = false,length = 11)
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
