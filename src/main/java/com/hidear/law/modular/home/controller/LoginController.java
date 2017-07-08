package com.hidear.law.modular.home.controller;

import com.google.code.kaptcha.Constants;
import com.hidear.law.common.exception.InvalidKaptchaException;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.util.ToolUtil;
import com.hidear.law.modular.home.model.LoginInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.hidear.law.core.support.HttpKit.getIp;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login",method =RequestMethod.GET)
    public String login(){
        return "/login.html";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(LoginInfo info){

        if(ToolUtil.getKaptchaOnOff()){
            String code = (String)HttpKit.getRequest().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(ToolUtil.isEmpty(info.getKaptcha()) || !info.getKaptcha().equals(code)){
                throw new InvalidKaptchaException();
            }
        }

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(info.getUsername(), info.getPassword().toCharArray());
        token.setRememberMe(true);
        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        HttpKit.getRequest().getSession().setAttribute("shiroUser", shiroUser);
        HttpKit.getRequest().getSession().setAttribute("username", shiroUser.getUsername());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag",true);

        return "登录成功！！！";
    }
}
