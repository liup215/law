package com.hidear.law.modular.user.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/7/2.
 */
@Entity
@Table(name="lw_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length=11)
    private Integer id;

    @Column(name="username",nullable = false,length = 255)
    private String username;

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
}
