package com.hidear.law.modular.admin.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acer on 2017/7/1.
 */

@Entity
@Table(name="lw_admin_loginlog")
public class LoginLog {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 65)
    private Integer id;

    /**
     * 日志名称
     */
    @Column(name = "logname",nullable = false,length = 255)
    private String logname;
    /**
     * 管理员id
     */
    @Column(name = "userid",nullable = false,length = 65)
    private Integer userid;
    /**
     * 创建时间
     */
    @Column(name = "createtime",nullable = false)
    private Date createtime;
    /**
     * 是否执行成功
     */
    @Column(name = "succeed",nullable = false,length = 255)
    private String succeed;
    /**
     * 具体消息
     */
    @Type(type = "text")
    @Column(name = "message",nullable = false)
    private String message;
    /**
     * 登录ip
     */
    @Column(name = "ip",nullable = false,length = 255)
    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
