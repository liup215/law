package com.hidear.law.modular.sms.dao;

import com.hidear.law.modular.sms.model.SMSPlugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/10/11.
 */
public interface SMSPluginRepository extends JpaRepository<SMSPlugin,Integer>,JpaSpecificationExecutor<SMSPlugin>{

}
