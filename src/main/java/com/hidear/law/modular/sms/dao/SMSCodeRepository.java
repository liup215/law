package com.hidear.law.modular.sms.dao;

import com.hidear.law.modular.sms.model.SMSCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/10/9.
 */
public interface SMSCodeRepository extends JpaRepository<SMSCode,Integer>,JpaSpecificationExecutor<SMSCode>{
}
