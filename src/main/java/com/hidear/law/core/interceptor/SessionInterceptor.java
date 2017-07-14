package com.hidear.law.core.interceptor;

import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.util.HttpSessionHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/14.
 */

@Aspect
@Component
public class SessionInterceptor {

    @Pointcut("execution(* com.hidear.law.modular.controller.*.*(..))")
    public void cutService(){

    }

    @Around("cutService()")
    public Object sessionKit(ProceedingJoinPoint point)throws Throwable{
        HttpSessionHolder.put(HttpKit.getRequest().getSession());
        try {
            return point.proceed();
        } finally {
            HttpSessionHolder.remove();
        }
    }
}
