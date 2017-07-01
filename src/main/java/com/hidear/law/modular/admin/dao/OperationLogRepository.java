package com.hidear.law.modular.admin.dao;

import com.hidear.law.modular.admin.model.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/7/1.
 */
public interface OperationLogRepository extends JpaRepository<OperationLog,Integer>{
}
