package com.hidear.law.modular.common.dao;

import com.hidear.law.modular.common.model.SMSTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/10/9.
 */
public interface SMSTemplateRepository extends JpaRepository<SMSTemplate,Integer>,JpaSpecificationExecutor<SMSTemplate> {
}
