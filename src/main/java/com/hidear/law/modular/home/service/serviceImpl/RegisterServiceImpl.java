package com.hidear.law.modular.home.service.serviceImpl;

import com.hidear.law.common.constant.status.RegisterStatus;
import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.util.MD5Util;
import com.hidear.law.modular.home.model.RegisterInfo;
import com.hidear.law.modular.home.model.RegisterTip;
import com.hidear.law.modular.home.service.IRegisterService;
import com.hidear.law.modular.user.dao.UserRepository;
import com.hidear.law.modular.user.model.User;
import com.hidear.law.modular.user.service.IUserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.hidear.law.core.support.HttpKit.getIp;

/**
 * Created by Administrator on 2017/7/5.
 */
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    IUserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public RegisterTip doRegister(RegisterInfo info) {
        RegisterTip tip = checkInfo(info);
        if(tip!=null){
            return tip;
        }

        tip = new RegisterTip();
        User user = getUserByInfo(info);
        user = userService.createUser(user);

        tip.setStatus(RegisterStatus.SUCCESS);
        tip.setUser(user);

        //登录
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(info.getUsername(), info.getPassword().toCharArray());
        token.setRememberMe(true);
        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        HttpKit.getRequest().getSession().setAttribute("shiroUser", shiroUser);
        HttpKit.getRequest().getSession().setAttribute("username", shiroUser.getUsername());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag",true);

        return tip;
    }

    public RegisterTip checkInfo(RegisterInfo info){
        RegisterTip tip = new RegisterTip();
        if(!info.getVerifyCode().equals("111111")){
            tip.setStatus(RegisterStatus.WRONG_VERIFY);
            return tip;
        }

        if(!info.getPassword().equals(info.getPasswordConfirm())){
            tip.setStatus(RegisterStatus.WRONG_PASSWORD_CONFIRM);
            return tip;
        }

        User user = userRepository.findByPhoneNumber(info.getPhone());
        if(user != null){
            tip.setStatus(RegisterStatus.DUPLICTED_PHONE);
            return tip;
        }

        user = userRepository.findByUsername(info.getUsername());
        if(user != null){
            tip.setStatus(RegisterStatus.DUPLICTED_USERNAME);
        }

        return null;
    }

    private User getUserByInfo(RegisterInfo info){
        User user = new User();
        user.setPhoneNumber(info.getPhone());
        user.setPassword(MD5Util.encrypt(info.getPassword()));
        user.setUsername(info.getPhone());
        user.setCoin(0.00);
        user.setRegisterTime(new Date());
        user.setLastLoginTime(new Date());
        user.setSalt(ShiroKit.getRandomSalt(10));
        user.setStatus(UserStatus.OK.getCode());

        return user;
    }
}
