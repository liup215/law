package com.hidear.law.modular.common.dao;

import com.hidear.law.modular.common.model.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/7/8.
 */
public interface OperationRepository extends JpaRepository<OperationLog,Integer>{
}
