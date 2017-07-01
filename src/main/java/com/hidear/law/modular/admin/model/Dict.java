package com.hidear.law.modular.admin.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/7/1.
 */
@Entity
@Table(name="lw_admin_dict")
public class Dict {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 11)
    private Integer id;

    /**
     * 排序
     */
    @Column(name = "num",nullable = false,length = 11)
    private Integer num;
    /**
     * 父级字典
     */
    @Column(name = "pid",nullable = false,length = 11)
    private Integer pid;
    /**
     * 名称
     */
    @Column(name = "name",nullable = false,length = 255)
    private String name;
    /**
     * 提示
     */
    @Column(name = "tips",nullable = false,length = 255)
    private String tips;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
