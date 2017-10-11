package com.hidear.law.modular.sms.dao;

import com.hidear.law.modular.sms.model.SMSTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/10/9.
 */
public interface SMSTemplateRepository extends JpaRepository<SMSTemplate,Integer>,JpaSpecificationExecutor<SMSTemplate> {

    public SMSTemplate findByType(Integer type);
}
