package com.hidear.law.modular.admin.dao;

import com.hidear.law.modular.admin.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/1.
 */
public interface MenuRepository extends JpaRepository<Menu,Integer>{
}
