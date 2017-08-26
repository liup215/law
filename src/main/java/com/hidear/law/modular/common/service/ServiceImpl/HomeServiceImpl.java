package com.hidear.law.modular.common.service.ServiceImpl;

import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.util.MD5Util;
import com.hidear.law.modular.User.dao.UserRepository;
import com.hidear.law.modular.User.model.User;
import com.hidear.law.modular.common.service.IHomeService;
import com.hidear.law.modular.transfer.RegisterTF;
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
    public static Map<String,String> tokenMap = new HashedMap();
    public static Map<String,ShiroUser> loginUserMap = new HashMap<>();

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        String token = tokenMap.get(username);
        ShiroUser shiroUser = null;
        if(token==null){
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
        }else{
            shiroUser = loginUserMap.get(token);
            loginUserMap.remove(token);
        }

        token = MD5Util.encrypt(username+password+new Date().getTime());
        loginUserMap.put(token,shiroUser);
        tokenMap.put(username,token);

        return token;
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
}
