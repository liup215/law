package com.hidear.law.modular.business.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/7.
 *
 */
@Entity
@Table(name="lw_businessEnterPriseAsset")
public class EnterpriseAsset {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 45)
    private Long id;

    @Column(name="name",nullable = false,length = 45)
    private String name;

    /**
     * 最低金额（万元）
     */
    @Column(name="low",nullable = false,length = 10)
    private Double low;
    /**
     * 最高金额（万元）
     */
    @Column(name="high",nullable = false,length = 10)
    private Double high;

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

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Date getRmTime() {
        return rmTime;
    }

    public void setRmTime(Date rmTime) {
        this.rmTime = rmTime;
    }
}
