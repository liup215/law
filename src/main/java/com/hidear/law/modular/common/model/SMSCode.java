package com.hidear.law.modular.common.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/9.
 */
@Entity
@Table(name="lw_sms_verify")
public class SMSCode {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 11)
    private Integer id;

    @Column(name="phone",nullable = false,length = 20)
    private String phone;

    @Column(name="code",nullable = false,length = 6)
    private String code;

    @Column(name="ask_ip",nullable = false,length = 15)
    private String ip;

    @Column(name="ask_time",nullable = false,length = 45)
    private Long askTime;

    @Column(name="status",nullable = false,length = 5)
    private Integer status;

    public SMSCode() {
    }

    public SMSCode(String phone, String code, String ip, Long askTime, Integer status) {

        this.phone = phone;
        this.code = code;
        this.ip = ip;
        this.askTime = askTime;
        this.status = status;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getAskTime() {
        return askTime;
    }

    public void setAskTime(Long askTime) {
        this.askTime = askTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SMSCode{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", ip='" + ip + '\'' +
                ", askTime=" + askTime +
                ", status=" + status +
                '}';
    }
}
