package com.hidear.law.modular.admin.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acer on 2017/7/1.
 */
@Entity
@Table(name="lw_admin_notice")
public class Notice {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 11)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title",nullable = false,length = 255)
    private String title;
    /**
     * 类型
     */
    @Column(name = "type",nullable = false,length = 11)
    private Integer type;
    /**
     * 内容
     */
    @Type(type = "text")
    @Column(name = "content",nullable = false)
    private String content;
    /**
     * 创建时间
     */
    @Column(name = "createtime",nullable = false)
    private Date createtime;
    /**
     * 创建人
     */
    @Column(name = "creater",nullable = false,length = 11)
    private Integer creater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }
}
