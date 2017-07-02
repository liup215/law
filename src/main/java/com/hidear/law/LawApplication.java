package com.hidear.law;

import com.hidear.law.config.properties.LawProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/7/1.
 */

@SpringBootApplication
public class LawApplication extends WebMvcConfigurerAdapter {
    protected final static Logger logger = LoggerFactory.getLogger(LawApplication.class);

    @Autowired
    LawProperties lawProperties;

    public static void main(String[] args){
        SpringApplication.run(LawApplication.class,args);
        logger.info("LawApplication Start success!!!");
    }
}
