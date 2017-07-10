package com.hidear.law.modular.dao;

import com.hidear.law.modular.model.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/7/8.
 */
public interface OperationRepository extends JpaRepository<OperationLog,Integer>{
}
