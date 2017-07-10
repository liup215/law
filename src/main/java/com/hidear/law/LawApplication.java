package com.hidear.law;

import com.hidear.law.config.properties.LawProperties;
import com.hidear.law.core.log.LogObjectHolder;
import com.hidear.law.core.shiro.factory.IShiro;
import com.hidear.law.core.shiro.factory.ShiroFactory;
import com.hidear.law.core.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/7/1.
 */
@EnableTransactionManagement
@SpringBootApplication
@DependsOn("springContextHolder")
public class LawApplication extends WebMvcConfigurerAdapter {
    protected final static Logger logger = LoggerFactory.getLogger(LawApplication.class);

    @Autowired
    LawProperties lawProperties;


    public static void main(String[] args){
        ShiroFactory.me();
        SpringApplication.run(LawApplication.class,args);
        logger.info("LawApplication Start success!!!");
    }
}
