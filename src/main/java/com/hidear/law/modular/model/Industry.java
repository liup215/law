package com.hidear.law.modular.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/7.
 */
@Entity
@Table(name="lw_business_industry")
public class Industry {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 45)
    private Long id;

    @Column(name="name",nullable = false,length = 45)
    private String name;

    @Column(name="pId",nullable = false,length = 45)
    private String pId;

    @Column(name="status",nullable = false,length = 10)
    private Integer status;

    @Column(name="cTime",nullable = false)
    private Date cTime;

    @Column(name="rmTime",nullable = true)
    private Date rmTime;

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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getRmTime() {
        return rmTime;
    }

    public void setRmTime(Date rmTime) {
        this.rmTime = rmTime;
    }
}
