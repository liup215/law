package com.hidear.law.modular.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/10.
 */

@Entity
@Table(name="lw_case_tax")
public class DemandTax {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 45)
    private Integer id;

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @Column(name="contact",nullable = false,length = 45)
    private String contact;

    @Column(name="phoneNumber",nullable = false,length = 25)
    private String phoneNumber;

    @Column(name="province",nullable = false,length = 20)
    private String province;

    @Column(name="city",nullable = false,length = 20)
    private String city;

    @Column(name="town",nullable = false,length = 20)
    private String town;

    @Column(name="county",nullable = false,length = 20)
    private String county;

    @Column(name="detail_address",nullable = false,length = 250)
    private String detailAddress;

    @Column(name="scale",nullable = false,length = 75)
    private Integer scale;

    @Column(name = "assets",nullable = false,length = 45)
    private Double assets;


    @Column(name = "output",nullable = false,length = 45)
    private Double output;

    @Column(name = "industry",nullable = false,length = 125)
    private String industry;

    @Column(name="case_detail",nullable = false,length = 300)
    @Type(type = "text")
    private String caseDetail;

    @Column(name="work_type",nullable = false,length = 2)
    private Integer workType;

    @Column(name="post",nullable = false,length = 2)
    private Integer post;

    @Column(name="submit_time",nullable = false,length = 45)
    private Long submitTime;

    @Column(name="update_time",nullable = false,length = 45)
    private Long updateTime;

    @Column(name="status",nullable = false,length = 2)
    private Integer status;

    @Column(name="visitCount",nullable = false,length = 45)
    private Integer visitCount;

    public DemandTax() {
    }

    public DemandTax(String name, String contact, String phoneNumber, String province, String city, String town, String county, String detailAddress, Integer scale, Double assets, Double output, String industry, String caseDetail, Integer workType, Integer post, Long submitTime, Long updateTime, Integer status, Integer visitCount) {
        this.name = name;
        this.contact = contact;
        this.phoneNumber = phoneNumber;
        this.province = province;
        this.city = city;
        this.town = town;
        this.county = county;
        this.detailAddress = detailAddress;
        this.scale = scale;
        this.assets = assets;
        this.output = output;
        this.industry = industry;
        this.caseDetail = caseDetail;
        this.workType = workType;
        this.post = post;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Double getAssets() {
        return assets;
    }

    public void setAssets(Double assets) {
        this.assets = assets;
    }

    public Double getOutput() {
        return output;
    }

    public void setOutput(Double output) {
        this.output = output;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(String caseDetail) {
        this.caseDetail = caseDetail;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
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
        return "DemandTax{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", county='" + county + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", scale='" + scale + '\'' +
                ", assets='" + assets + '\'' +
                ", output='" + output + '\'' +
                ", industry='" + industry + '\'' +
                ", caseDetail='" + caseDetail + '\'' +
                ", workType=" + workType +
                ", post=" + post +
                ", submitTime=" + submitTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", visitCount=" + visitCount +
                '}';
    }
}
