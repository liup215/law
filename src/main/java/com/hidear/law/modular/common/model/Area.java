package com.hidear.law.modular.common.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/21.
 */
@Entity
@Table(name="lw_area")
public class Area {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 11)
    private Integer id;

    @Column(name="parentId",nullable = false,length = 11)
    private Integer parentId;

    @Column(name="name",nullable = false,length = 50)
    private String name;

    @Column(name="shortName",nullable = false,length = 50)
    private String shortName;

    @Column(name="longitude",nullable = false,length = 50)
    private Double longitude;

    @Column(name="latitude",nullable = false,length = 50)
    private Double latitude;

    @Column(name="level",nullable = false,length = 1)
    private Integer level;

    @Column(name="sort",nullable = false,length = 3)
    private Integer sort;

    @Column(name="status",nullable = false,length = 1)
    private Integer status;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", level=" + level +
                ", sort=" + sort +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Area(Integer parentId, String name, String shortName, Double longitude, Double latitude, Integer level, Integer sort, Integer status) {

        this.parentId = parentId;
        this.name = name;
        this.shortName = shortName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.level = level;
        this.sort = sort;
        this.status = status;
    }

    public Area() {

    }
}
