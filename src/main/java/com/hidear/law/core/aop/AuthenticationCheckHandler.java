package com.hidear.law.core.aop;

import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.core.token.TokenModel;
import com.hidear.law.core.token.config.AuthConstants;
import com.hidear.law.core.token.manager.TokenManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TokenManager tokenManager;

    @Pointcut(value = "@annotation(com.hidear.law.common.annotion.AuthenticationCheck)")
    public void cutAuth(){

    }

    @Around("cutAuth()")
    public Object doAuthCheck(ProceedingJoinPoint point) throws Throwable{
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String authorization  = request.getHeader(AuthConstants.AUTHORIZATION);

        TokenModel model = tokenManager.getToken(authorization);
        if(tokenManager.checkToken(model)){
            return point.proceed();
        }

        throw new BussinessException(BizExceptionEnum.USER_NOT_LOGIN);
    }
}
