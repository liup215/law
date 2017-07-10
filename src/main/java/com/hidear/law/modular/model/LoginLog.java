package com.hidear.law.modular.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/7.
 */
@Entity
@Table(name="lw_login_log")
public class LoginLog {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 45)
    private Long id;
    /**
     * 日志名称
     */
    @Column(name="logname",nullable = false,length = 45)
    private String logname;
    /**
     * 管理员id
     */
    @Column(name="userid",nullable = false,length = 45)
    private Integer userid;
    /**
     * 创建时间
     */
    @Column(name="createtime",nullable = false)
    private Date createtime;
    /**
     * 是否执行成功
     */
    @Column(name="succeed",nullable = false,length = 45)
    private String succeed;
    /**
     * 具体消息
     */
    @Column(name="message",nullable = true,length = 100)
    private String message;
    /**
     * 登录ip
     */
    @Column(name="ip",nullable = false,length = 20)
    private String ip;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
