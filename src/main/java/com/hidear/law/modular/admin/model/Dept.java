package com.hidear.law.modular.admin.model;

import io.swagger.models.auth.In;

import javax.persistence.*;

/**
 * Created by acer on 2017/7/1.
 */
@Entity
@Table(name="lw_admin_dept")
public class Dept {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 11)
    private Integer id;

    /**
     * 排序
     */
    @Column(name="num",nullable = false,length = 11)
    private Integer num;
    /**
     * 父部门id
     */
    @Column(name="pid",nullable = false,length = 11)
    private Integer pid;
    /**
     * 简称
     */
    @Column(name="simplename",nullable = false,length = 45)
    private String simplename;
    /**
     * 全称
     */
    @Column(name="fullname",nullable = false,length = 255)
    private String fullname;
    /**
     * 提示
     */
    @Column(name="tips",nullable = false,length = 255)
    private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
    @Column(name="version",nullable = false,length = 11)
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSimplename() {
        return simplename;
    }

    public void setSimplename(String simplename) {
        this.simplename = simplename;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
