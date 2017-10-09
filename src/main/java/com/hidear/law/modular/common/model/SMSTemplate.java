package com.hidear.law.modular.common.model;

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

    @Column(name="sign",nullable = false,length = 10)
    private String sign;

    @Column(name="content",nullable = false,length = 255)
    private String content;

    @Column(name="scene",nullable = false,length = 10)
    private String scene;

    public SMSTemplate() {
    }

    public SMSTemplate(String sign, String content, String scene) {

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
                ", sign='" + sign + '\'' +
                ", content='" + content + '\'' +
                ", scene='" + scene + '\'' +
                '}';
    }
}
