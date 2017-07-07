package com.hidear.law.modular.home.service;

import com.hidear.law.core.util.MD5Util;
import com.hidear.law.modular.home.model.RegisterInfo;
import com.hidear.law.modular.home.model.SuccessTip;
import com.hidear.law.modular.user.dao.UserRepository;
import com.hidear.law.modular.user.model.User;
import com.hidear.law.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/5.
 */
public class RegisterService {

    @Autowired
    UserService service;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Object doRegister(RegisterInfo info) {
        SuccessTip tip = (SuccessTip) checkInfo(info);
        if(tip!=null){
            return tip;
        }

        tip = new SuccessTip();
        User user = getUserByInfo(info);
        user = service.createUser(user);
        if(user==null){
            System.out.println(info.getVerifyCode());
            tip.setCode("4");
            tip.setStatus("failure");
            tip.setMessage("数据库写入失败");
            return tip;
        }

        tip.setStatus("success");
        tip.setCode("0");
        tip.setMessage("注册成功！！！");
        tip.setUser(user);
        return tip;
    }

    public Object checkInfo(RegisterInfo info){
        SuccessTip tip = new SuccessTip();
        if(!info.getVerifyCode().equals("111111")){
            System.out.println(info.getVerifyCode());
            tip.setCode("1");
            tip.setStatus("failure");
            tip.setMessage("验证码输入错误");
            return tip;
        }

        if(!info.getPassword().equals(info.getPasswordConfirm())){
            tip.setCode("2");
            tip.setStatus("failure");
            tip.setMessage("两次输入密码不一样");
            return tip;
        }

        User user = userRepository.findByPhoneNumber(info.getPhone());
        if(user != null){
            tip.setCode("3");
            tip.setStatus("failure");
            tip.setMessage("手机号码已存在！！！");
            return tip;
        }

        return null;
    }

    private User getUserByInfo(RegisterInfo info){
        User user = new User();
        user.setMoblilePhone(info.getPhone());
        user.setPassword(MD5Util.encrypt(info.getPassword()));
        user.setUsername(info.getPhone());
        user.setCoinNum(0.00);
        user.setRegisterTime(new Date());
        user.setLastLoginTime(new Date());

        return user;
    }
}
