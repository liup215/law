package com.hidear.law.modular.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/7.
 */
@Entity
@Table(name="lw_user_taxaccountant")
public class TaxAccountant {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 45)
    private Long id;

    @Column(name="userid",nullable=false,length = 45)
    private Long userid;

    /**
     * 职业
     */
    @Column(name="occupationType",nullable = false,length = 45)
    private Long occupationType;

}
