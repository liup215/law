package com.hidear.law.modular.user.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/5.
 */
@Entity
@Table(name="lw_usertype")
public class UserType {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 75)
    private Long id;

    @Column(name="name",nullable = false,length = 45)
    private String name;

    @Column(name="status",nullable = false,length = 45)
    private String status;

    @Column(name="wTime",nullable = false)
    private Date wTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getwTime() {
        return wTime;
    }

    public void setwTime(Date wTime) {
        this.wTime = wTime;
    }
}
