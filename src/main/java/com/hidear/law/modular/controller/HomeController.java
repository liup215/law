package com.hidear.law.modular.controller;

import com.google.code.kaptcha.Constants;
import com.hidear.law.common.exception.InvalidKaptchaException;
import com.hidear.law.common.exception.InvalidVarifyException;
import com.hidear.law.common.exception.PasswordConfirmException;
import com.hidear.law.common.exception.UserExistException;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.util.ToolUtil;
import com.hidear.law.modular.dao.UserRepository;
import com.hidear.law.modular.model.User;
import com.hidear.law.modular.service.IUserService;
import com.hidear.law.modular.transfer.LoginInfo;
import com.hidear.law.modular.transfer.RegisterInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 2017/7/1.
 */
@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(){
        return "/index.html";
    }

    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String home(){
        return "/index.html";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return "redirect:/";
        } else {
            return "/login.html";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(LoginInfo info){
        //验证验证码是否正确
        if(ToolUtil.getKaptchaOnOff()){
            String kaptcha = info.getKaptcha();
            String code = (String) HttpKit.getRequest().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(ToolUtil.isEmpty(kaptcha) || !kaptcha.equals(code)){
                throw new InvalidKaptchaException();
            }
        }

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(info.getUsername(),info.getPassword());

        token.setRememberMe(true);

        currentUser.login(token);
        ShiroUser shiroUser = ShiroKit.getUser();
        HttpKit.getRequest().getSession().setAttribute("shiroUser",shiroUser);
        HttpKit.getRequest().getSession().setAttribute("username",shiroUser.getUsername());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), HttpKit.getRequest().getRemoteHost()));

        ShiroKit.getSession().setAttribute("sessionFlag",true);
        return "redirect:/";

    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(){
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), HttpKit.getRequest().getRemoteHost()));
        ShiroKit.getSubject().logout();
        return "redirect:/login";
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(){
        return "/register.html";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(RegisterInfo info){
        //判断手机验证码是否正确
        String varifyCode = "1011";
        if(ToolUtil.isEmpty(info.getVerifyCode())|| !varifyCode.equals(info.getVerifyCode())){
            throw new InvalidVarifyException();
        }

        //判断手机号是否存在
        if(ToolUtil.isEmpty(info.getPhone())|| userRepository.findByPhoneNumber(info.getPhone())!=null){
            throw new RuntimeException();
        }

        //判断用户名是否存在
        if(ToolUtil.isEmpty(info.getUsername())||userRepository.findByUsername(info.getUsername())!=null){
            throw new UserExistException();
        }

        //判断两次输入密码是否相同
        if((ToolUtil.isEmpty(info.getPassword()) && ToolUtil.isEmpty(info.getPasswordConfirm()))|| info.getPassword()!=info.getPasswordConfirm()){
            throw new PasswordConfirmException();
        }

        //创建用户
        User user = userService.createUser(info);

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(info.getUsername(),info.getPassword());

        token.setRememberMe(true);

        currentUser.login(token);
        ShiroUser shiroUser = ShiroKit.getUser();
        HttpKit.getRequest().getSession().setAttribute("shiroUser",shiroUser);
        HttpKit.getRequest().getSession().setAttribute("username",shiroUser.getUsername());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), HttpKit.getRequest().getRemoteHost()));

        ShiroKit.getSession().setAttribute("sessionFlag",true);
        return "redirect:/";
    }
}
