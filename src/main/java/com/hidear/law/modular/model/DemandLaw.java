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

    /**
     * 联系人所在地
     */
    @Column(name="contactAddress",nullable = false)
    private String contactAddress;

    /**
     * 案件类型
     */
    @Column(name="case_type",nullable = false,length = 20)
    private Integer caseType;

    /**
     * 被告所在地
     */
    @Column(name="accused_area",nullable = false)
    private String accusedArea;

    /**
     * 合同签约地
     */
    @Column(name="contract_area",nullable = false)
    private String contractArea;

    /**
     * 案发地
     */
    @Column(name="venue_area",nullable = false)
    private String venueArea;

    @Column(name="work_type",nullable = false,length = 2)
    private Integer workType;

    @Column(name="case_detail",nullable = false,length = 300)
    @Type(type = "text")
    private String caseDetail;

    @Column(name="submit_time",nullable = false,length = 45)
    private Long submitTime;

    @Column(name="update_time",nullable = false,length = 45)
    private Long updateTime;

    @Column(name="status",nullable = false,length = 2)
    private Integer status;

    @Column(name="visitCount",nullable = false,length = 45)
    private Integer visitCount;

    public DemandLaw() {
    }

    public DemandLaw(String name, String contact, String phone, String contactAddress, Integer caseType, String accusedArea, String contractArea, String venueArea, String caseDetail, Long submitTime, Long updateTime, Integer status, Integer visitCount) {
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.contactAddress = contactAddress;
        this.caseType = caseType;
        this.accusedArea = accusedArea;
        this.contractArea = contractArea;
        this.venueArea = venueArea;
        this.caseDetail = caseDetail;
        this.submitTime = submitTime;
        this.updateTime = updateTime;
        this.status = status;
        this.visitCount = visitCount;
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

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
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

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    @Override
    public String toString() {
        return "DemandLaw{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", caseType=" + caseType +
                ", accusedArea='" + accusedArea + '\'' +
                ", contractArea='" + contractArea + '\'' +
                ", venueArea='" + venueArea + '\'' +
                ", caseDetail='" + caseDetail + '\'' +
                ", submitTime=" + submitTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", visitCount=" + visitCount +
                '}';
    }
}
