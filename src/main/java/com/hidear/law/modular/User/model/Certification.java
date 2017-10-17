package com.hidear.law.modular.User.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/17.
 */
@Entity
@Table(name = "lw_certification")
public class Certification {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 65)
    private Integer id;

    @Column(name = "user_name",nullable = false,length = 20)
    private String userName;

    @Column(name = "truename" , nullable = false,length = 20)
    private String trueName;

    @Column(name="id_number",nullable = false,length = 50)
    private String idNumber;

    @Column(name = "id_face_image",nullable = false)
    private String idFaceImage;

    @Column(name = "id_back_image",nullable = false)
    private String idBackImage;

    @Column(name="area",nullable = false,length = 100)
    private String area;

    @Column(name = "detail_address",nullable = false,length = 100)
    private String detailAddress;

    @Column(name = "application_date",nullable = false)
    private Long applicationDate;

    @Column(name = "audit_time",nullable = true)
    private Long auditDate;

    @Column(name = "state",nullable = false,length = 10)
    private Integer status;

    public Certification() {
    }

    public Certification(String userName, String trueName, String idNumber, String idFaceImage, String idBackImage, String area, String detailAddress, Long applicationDate, Long auditDate, Integer status) {

        this.userName = userName;
        this.trueName = trueName;
        this.idNumber = idNumber;
        this.idFaceImage = idFaceImage;
        this.idBackImage = idBackImage;
        this.area = area;
        this.detailAddress = detailAddress;
        this.applicationDate = applicationDate;
        this.auditDate = auditDate;
        this.status = status;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdFaceImage() {
        return idFaceImage;
    }

    public void setIdFaceImage(String idFaceImage) {
        this.idFaceImage = idFaceImage;
    }

    public String getIdBackImage() {
        return idBackImage;
    }

    public void setIdBackImage(String idBackImage) {
        this.idBackImage = idBackImage;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Long getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Long applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Long getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Long auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", idFaceImage='" + idFaceImage + '\'' +
                ", idBackImage='" + idBackImage + '\'' +
                ", area='" + area + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", applicationDate=" + applicationDate +
                ", auditDate=" + auditDate +
                ", status=" + status +
                '}';
    }
}
