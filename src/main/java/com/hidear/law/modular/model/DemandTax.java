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

    @Column(name="phone",nullable = false,length = 25)
    private String phone;

    @Column(name="scale",nullable = false,length = 75)
    private String scale;

    @Column(name = "assets",nullable = false,length = 45)
    private String assets;


    @Column(name = "output",nullable = false,length = 45)
    private String output;

    @Column(name = "area",nullable = false,length = 125)
    private String area;

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

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public void setCaseDetail(String case_detail) {
        this.caseDetail = case_detail;
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

    public void setUpdateTime(Long update_time) {
        this.updateTime = update_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DemandTax() {
    }

    public DemandTax(String contant, String phone, String scale, String assets, String output, String area, String industry, String case_detail, Integer workType, Integer post, Long submitTime, Long update_time, Integer status) {
        this.contact = contant;
        this.phone = phone;
        this.scale = scale;
        this.assets = assets;
        this.output = output;
        this.area = area;
        this.industry = industry;
        this.caseDetail = case_detail;
        this.workType = workType;
        this.post = post;
        this.submitTime = submitTime;
        this.updateTime = update_time;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DemandTax{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", scale='" + scale + '\'' +
                ", assets='" + assets + '\'' +
                ", output='" + output + '\'' +
                ", area='" + area + '\'' +
                ", industry='" + industry + '\'' +
                ", case_detail='" + caseDetail + '\'' +
                ", workType=" + workType +
                ", post=" + post +
                ", submitTime=" + submitTime +
                ", update_time=" + updateTime +
                ", status=" + status +
                '}';
    }
}
