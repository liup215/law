package com.hidear.law;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/7/1.
 */
@EnableTransactionManagement
@SpringBootApplication
public class LawApplication extends WebMvcConfigurerAdapter {
    protected final static Logger logger = LoggerFactory.getLogger(LawApplication.class);

    public static void main(String[] args){

        SpringApplication.run(LawApplication.class,args);
        logger.info("LawApplication Start success!!!");
    }
}
