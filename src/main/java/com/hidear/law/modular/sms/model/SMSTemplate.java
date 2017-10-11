package com.hidear.law.modular.sms.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/9.
 */
@Entity
@Table(name="lw_sms_tpl")
public class SMSTemplate {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 11)
    private Integer id;

    @Column(name="type",nullable = false,length = 10,unique = true)
    private Integer type;

    @Column(name="code",nullable = false,length = 20)
    private String code;

    @Column(name="sign",nullable = false,length = 10)
    private String sign;

    @Column(name="content",nullable = false,length = 255)
    private String content;

    @Column(name="scene",nullable = false,length = 10)
    private String scene;

    public SMSTemplate() {
    }

    public SMSTemplate(Integer type, String code, String sign, String content, String scene) {
        this.type = type;
        this.code = code;
        this.sign = sign;
        this.content = content;
        this.scene = scene;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "SMSTemplate{" +
                "id=" + id +
                ", type=" + type +
                ", code=" + code +
                ", sign='" + sign + '\'' +
                ", content='" + content + '\'' +
                ", scene='" + scene + '\'' +
                '}';
    }

}
