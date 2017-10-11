package com.hidear.law.modular.sms.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/11.
 */
@Entity
@Table(name="lw_sms_plugin")
public class SMSPlugin {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length = 10)
    private Integer id;

    @Column(name = "url",nullable = false,length = 100)
    private String url;

    @Column(name = "appKey",nullable = false,length = 100)
    private String appKey;

    public SMSPlugin() {
    }

    public SMSPlugin(String url, String appKey) {

        this.url = url;
        this.appKey = appKey;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        return "SMSPlugin{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", appKey='" + appKey + '\'' +
                '}';
    }
}
