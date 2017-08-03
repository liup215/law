package com.hidear.law.modular.demand.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/10.
 */

@Entity
@Table(name="lw_demand_tax")
public class DemandTax {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 45)
    private Integer id;

    /**
     * 需求名称
     */
    @Column(name = "name",nullable = false,length = 20)
    private String name;

    /**
     * 需求联系人
     */
    @Column(name="contact",nullable = false,length = 45)
    private String contact;
    /**
     * 联系电话
     */
    @Column(name="phoneNumber",nullable = false,length = 25)
    private String phoneNumber;
    /**
     * 联系人所在地
     */
    @Column(name="contactAddress",nullable = false,length = 250)
    private String contactAddress;
    /**
     * 工作地点
     */
    @Column(name="workSpace",nullable = false,length = 250)
    private String workSpace;
    /**
     * 公司规模
     */
    @Column(name="scale",nullable = false,length = 75)
    private Integer scale;
    /**
     * 公司产值
     */
    @Column(name = "assets",nullable = false,length = 45)
    private Double assets;

    /**
     * 公司产量
     */
    @Column(name = "output",nullable = false,length = 45)
    private Double output;
    /**
     * 行业
     */
    @Column(name = "industry",nullable = false,length = 125)
    private String industry;
    /**
     * 需求详情
     */
    @Column(name="case_detail",nullable = false,length = 300)
    @Type(type = "text")
    private String caseDetail;
    /**
     * 工作类型，0兼职，1全职
     */
    @Column(name="work_type",nullable = false,length = 2)
    private Integer workType;
    /**
     * 岗位
     */
    @Column(name="post",nullable = false,length = 2)
    private Integer post;

    /**
     * 提交时间
     */
    @Column(name="submit_time",nullable = false,length = 45)
    private Long submitTime;

    /**
     * 更新时间
     */
    @Column(name="update_time",nullable = false,length = 45)
    private Long updateTime;

    /**
     * 状态
     */
    @Column(name="status",nullable = false,length = 2)
    private Integer status;

    /**
     * 访问次数
     */
    @Column(name="visitCount",nullable = false,length = 45)
    private Integer visitCount;

    public DemandTax() {
    }

    public DemandTax(String name, String contact, String phoneNumber, String contactAddress, String workSpace, Integer scale, Double assets, Double output, String industry, String caseDetail, Integer workType, Integer post, Long submitTime, Long updateTime, Integer status, Integer visitCount) {
        this.name = name;
        this.contact = contact;
        this.phoneNumber = phoneNumber;
        this.contactAddress = contactAddress;
        this.workSpace = workSpace;
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

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getWorkSpace() {
        return workSpace;
    }

    public void setWorkSpace(String workSpace) {
        this.workSpace = workSpace;
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
                ", contactAddress='" + contactAddress + '\'' +
                ", workSpace='" + workSpace + '\'' +
                ", scale=" + scale +
                ", assets=" + assets +
                ", output=" + output +
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
