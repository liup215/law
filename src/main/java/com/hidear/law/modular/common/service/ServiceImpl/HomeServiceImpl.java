package com.hidear.law.modular.common.service.ServiceImpl;

import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.common.constant.type.LoginType;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.shiro.factory.ShiroFactory;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.token.TokenModel;
import com.hidear.law.core.token.manager.TokenManager;
import com.hidear.law.core.util.MD5Util;
import com.hidear.law.modular.User.dao.UserRepository;
import com.hidear.law.modular.User.model.User;
import com.hidear.law.modular.common.service.IHomeService;
import com.hidear.law.modular.transfer.LoginTF;
import com.hidear.law.modular.transfer.RegisterTF;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/25.
 */
@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @Override
    public TokenModel login(LoginTF loginTF) {
        ShiroUser shiroUser = null;
        TokenModel model = null;

        if(loginTF.getLoginType()== LoginType.USERNAME_PASSWORD.getType()){
            String username = loginTF.getPhoneNumber();
            String password = loginTF.getPassword();
            Subject currentUser = ShiroKit.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password.toCharArray());
            usernamePasswordToken.setRememberMe(true);
            currentUser.login(usernamePasswordToken);

            shiroUser = ShiroKit.getUser();

            HttpKit.getRequest().getSession().setAttribute("shiroUser", shiroUser);
            HttpKit.getRequest().getSession().setAttribute("phone", shiroUser.getPhoneNumber());

            LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), HttpKit.getIp()));
            User user = userRepository.findByPhoneNumber(username);
            user.setLastLoginTime((new Date()).getTime());
            userRepository.save(user);
            ShiroKit.getSession().setAttribute("sessionFlag",true);

            model = tokenManager.createToken(user.getId());
        }else if(loginTF.getLoginType()==LoginType.SMS_CODE.getType()){

            String phone = loginTF.getPhoneNumber();
            User user = userRepository.findByPhoneNumber(phone);

            shiroUser = ShiroFactory.me().shiroUser(user);
            HttpKit.getRequest().getSession().setAttribute("shiroUser", shiroUser);
            HttpKit.getRequest().getSession().setAttribute("phone", shiroUser.getPhoneNumber());
            LogManager.me().executeLog(LogTaskFactory.loginLog(user.getId(),HttpKit.getIp()));

            user.setLastLoginTime((new Date()).getTime());
            userRepository.save(user);
            ShiroKit.getSession().setAttribute("sessionFlag",true);

            model = tokenManager.createToken(user.getId());
        }else{
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }


        return model;
    }

    @Override
    public void register(RegisterTF registerTF) {
        User user = new User();
        //完善账号信息
        BeanUtils.copyProperties(registerTF,user);
        user.setUsername(registerTF.getPhoneNumber());
        user.setCoin(0.00);
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(ShiroKit.md5(registerTF.getPassword(),user.getSalt()));
        user.setRegisterTime((new Date()).getTime());
        user.setStatus(UserStatus.OK.getCode());

        System.out.println(user.toString());
        userRepository.save(user);
    }

    @Override
    public void logout(String authorization) {
        TokenModel model = tokenManager.getToken(authorization);
        if(tokenManager.checkToken(model)){
            tokenManager.deleteToken(model.getUserId());
        }

        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), HttpKit.getRequest().getRemoteHost()));
        ShiroKit.getSubject().logout();
    }

    @Override
    public boolean loginCheck(String authorization) {
        TokenModel tokenModel = tokenManager.getToken(authorization);
        return tokenManager.checkToken(tokenModel);
    }
}
