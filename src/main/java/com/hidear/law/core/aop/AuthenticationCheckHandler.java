package com.hidear.law.core.aop;

import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.modular.common.service.ServiceImpl.HomeServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/26.
 */
@Aspect
@Component
public class AuthenticationCheckHandler {

    @Pointcut(value = "@annotation(com.hidear.law.common.annotion.AuthenticationCheck)")
    public void cutAuth(){

    }

    @Around("cutAuth()")
    public Object doAuthCheck(ProceedingJoinPoint point) throws Throwable{
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String token = request.getHeader("token");
        if(token != null){
            ShiroUser shiroUser = HomeServiceImpl.loginUserMap.get(token);
            if(shiroUser!=null){
                return point.proceed();
            }
        }

        throw new BussinessException(BizExceptionEnum.USER_NOT_LOGIN);
    }
}
