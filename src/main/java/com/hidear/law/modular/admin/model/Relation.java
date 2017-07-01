package com.hidear.law.modular.admin.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/7/1.
 */
@Entity
@Table(name="lw_admin_relation")
public class Relation {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,length = 11)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="menuId")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name="roleId")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
