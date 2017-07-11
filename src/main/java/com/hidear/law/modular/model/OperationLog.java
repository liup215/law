package com.hidear.law.modular.model;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acer on 2017/7/8.
 */

@Entity
@Table(name = "lw_operationLog")
public class OperationLog {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 45)
    private Integer id;

    /**
     * 日志类型
     */
    @Column(name = "logtype",nullable = false,length = 45)
    private String logtype;
    /**
     * 日志名称
     */
    @Column(name = "logname",nullable = false,length = 45)
    private String logname;
    /**
     * 用户id
     */
    @Column(name = "userid",nullable = false,length = 45)
    private Integer userid;
    /**
     * 类名称
     */
    @Column(name = "classname",nullable = true,length = 45)
    private String classname;
    /**
     * 方法名称
     */
    @Column(name = "method",nullable = true,length = 45)
    private String method;
    /**
     * 创建时间
     */
    @Column(name = "createtime",nullable = false)
    private Date createtime;
    /**
     * 是否成功
     */
    @Column(name = "succeed",nullable = false,length = 45)
    private String succeed;
    /**
     * 备注
     */
    @Type(type="text")
    @Column(name = "message",nullable = false)
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
}
