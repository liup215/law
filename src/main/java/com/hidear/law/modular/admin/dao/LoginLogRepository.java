package com.hidear.law.modular.admin.dao;

import com.hidear.law.modular.admin.model.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/7/1.
 */
public interface LoginLogRepository extends JpaRepository<LoginLog,Integer>{
}
