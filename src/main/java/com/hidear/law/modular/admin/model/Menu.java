package com.hidear.law.modular.admin.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/1.
 */
@Entity
@Table(name = "lw_admin_menu")
public class Menu {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 65)
    private Integer id;
    /**
     * 菜单编号
     */
    @Column(name="code",nullable = false,length = 255)
    private String code;
    /**
     * 菜单父编号
     */
    @Column(name="pcode",nullable = false,length = 255)
    private String pcode;
    /**
     * 当前菜单的所有父菜单编号
     */
    @Column(name="pcodes",nullable = false,length = 255)
    private String pcodes;
    /**
     * 菜单名称
     */
    @Column(name="name",nullable = false,length = 255)
    private String name;
    /**
     * 菜单图标
     */
    @Column(name="icon",nullable = false,length = 255)
    private String icon;
    /**
     * url地址
     */
    @Column(name="url",nullable = false,length = 255)
    private String url;
    /**
     * 菜单排序号
     */
    @Column(name="num",nullable = false,length = 65)
    private Integer num;
    /**
     * 菜单层级
     */
    @Column(name="levels",nullable = false,length = 65)
    private Integer levels;
    /**
     * 是否是菜单（1：是  0：不是）
     */
    @Column(name="ismenu",nullable = false,length = 11)
    private Integer ismenu;
    /**
     * 备注
     */
    @Column(name="tips",nullable = false,length = 255)
    private String tips;
    /**
     * 菜单状态 :  1:启用   0:不启用
     */
    @Column(name="status",nullable = false,length = 65)
    private Integer status;
    /**
     * 是否打开:    1:打开   0:不打开
     */
    @Column(name="isopen",nullable = false,length = 11)
    private Integer isopen;

    @OneToMany(mappedBy = "menu")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Relation> relation;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPcodes() {
        return pcodes;
    }

    public void setPcodes(String pcodes) {
        this.pcodes = pcodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsopen() {
        return isopen;
    }

    public void setIsopen(Integer isopen) {
        this.isopen = isopen;
    }

    public Set<Relation> getRelation() {
        return relation;
    }

    public void setRelation(Set<Relation> relation) {
        this.relation = relation;
    }
}
