package com.hidear.law.modular.common.dao;

import com.hidear.law.modular.common.model.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface LoginLogRepository extends JpaRepository<LoginLog,Integer>{
}
