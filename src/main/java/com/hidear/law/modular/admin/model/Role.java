package com.hidear.law.modular.admin.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by acer on 2017/7/1.
 */
@Entity
@Table(name="lw_admin_role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,length=11)
    private Integer id;

    /**
     * 序号
     */
    @Column(name = "num",nullable = false,length=11)
    private Integer num;
    /**
     * 父角色id
     */
    @Column(name = "pid",nullable = false,length=11)
    private Integer pid;
    /**
     * 角色名称
     */
    @Column(name = "name",nullable = false,length=255)
    private String name;
    /**
     * 部门名称
     */
    @Column(name = "deptid",nullable = false,length=11)
    private Integer deptid;
    /**
     * 提示
     */
    @Column(name = "tips",nullable = false,length=255)
    private String tips;
    /**
     * 保留字段(暂时没用）
     */
    @Column(name = "version",nullable = false,length=11)
    private Integer version;

    @OneToMany(mappedBy = "role")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Relation> relation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set<Relation> getRelation() {
        return relation;
    }

    public void setRelation(Set<Relation> relation) {
        this.relation = relation;
    }
}
