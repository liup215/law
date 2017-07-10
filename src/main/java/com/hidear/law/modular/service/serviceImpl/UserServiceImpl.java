package com.hidear.law.modular.service.serviceImpl;

import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.modular.dao.UserRepository;
import com.hidear.law.modular.model.User;
import com.hidear.law.modular.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by acer on 2017/7/2.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;




    @Override
    @Transactional
    public User createUser(){
        User user = new User();
        user.setSalt(ShiroKit.getRandomSalt(10));
        user.setStatus(1);
        user.setUserType("1");
        user.setPhoneNumber("13594298580");
        user.setCoin(0.00);
        user.setPassword("123456");
        user.setRegisterTime((new Date()).getTime());
        user.setUsername("liup215");

        userRepository.save(user);
        return user;
    };

    @Override
    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }


}

