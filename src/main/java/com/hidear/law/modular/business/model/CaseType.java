package com.hidear.law.modular.business.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/7.
 */
@Entity
@Table(name="lw_business_casetype")
public class CaseType {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 45)
    private Long id;

    @Column(name="name",nullable = false,length = 45)
    private String name;

    @Column(name="status",nullable = false,length = 10)
    private Integer status;

    @Column(name="cTime",nullable = false)
    private Date cTime;

    @Column(name="rmTime",nullable = true)
    private Date rmTime;
}
