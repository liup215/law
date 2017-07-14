package com.hidear.law.modular.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/10.
 */
@Entity
@Table(name="lw_demand_law")
public class DemandLaw {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 45)
    private Integer id;

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @Column(name="contact",nullable = false,length = 45)
    private String contact;

    @Column(name="phoneNumber",nullable = false,length = 25)
    private String phone;

    @Column(name="province",nullable = false,length = 20)
    private String province;

    @Column(name="city",nullable = false,length = 20)
    private String city;

    @Column(name="town",nullable = false,length = 20)
    private String town;

    @Column(name="county",nullable = false,length = 20)
    private String county;

    @Column(name="detail_address",nullable = false)
    private String detailAddress;

    @Column(name="case_type",nullable = false,length = 20)
    private Integer caseType;

    @Column(name="accused_area",nullable = false)
    private String accusedArea;

    @Column(name="contract_area",nullable = false)
    private String contractArea;

    @Column(name="venue_area",nullable = false)
    private String venueArea;

    @Column(name="case_detail",nullable = false,length = 300)
    @Type(type = "text")
    private String caseDetail;

    @Column(name="submit_time",nullable = false,length = 45)
    private Long submitTime;

    @Column(name="update_time",nullable = false,length = 45)
    private Long updateTime;

    @Column(name="status",nullable = false,length = 2)
    private Integer status;

    @Column(name="visitTime",nullable = false,length = 45)
    private Integer visitTime;

    public DemandLaw() {
    }

    public DemandLaw(String name, String contact, String phone, String province, String city, String town, String county, String detailAddress, Integer caseType, String accusedArea, String contractArea, String venueArea, String caseDetail, Long submitTime, Long updateTime, Integer status, Integer visitTime) {
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.town = town;
        this.county = county;
        this.detailAddress = detailAddress;
        this.caseType = caseType;
        this.accusedArea = accusedArea;
        this.contractArea = contractArea;
        this.venueArea = venueArea;
        this.caseDetail = caseDetail;
        this.submitTime = submitTime;
        this.updateTime = updateTime;
        this.status = status;
        this.visitTime = visitTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getAccusedArea() {
        return accusedArea;
    }

    public void setAccusedArea(String accusedArea) {
        this.accusedArea = accusedArea;
    }

    public String getContractArea() {
        return contractArea;
    }

    public void setContractArea(String contractArea) {
        this.contractArea = contractArea;
    }

    public String getVenueArea() {
        return venueArea;
    }

    public void setVenueArea(String venueArea) {
        this.venueArea = venueArea;
    }

    public String getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(String caseDetail) {
        this.caseDetail = caseDetail;
    }

    public Long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Long submitTime) {
        this.submitTime = submitTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return "DemandLaw{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", phoneNumber='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", county='" + county + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", caseType=" + caseType +
                ", accusedArea='" + accusedArea + '\'' +
                ", contractArea='" + contractArea + '\'' +
                ", venueArea='" + venueArea + '\'' +
                ", caseDetail='" + caseDetail + '\'' +
                ", submitTime=" + submitTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", visitTime=" + visitTime +
                '}';
    }
}
