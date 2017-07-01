package com.hidear.law.modular.admin.model;


import javax.persistence.*;

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
    private Long id;
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
}
