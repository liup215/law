package com.hidear.law.modular.service.serviceImpl;

import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.modular.dao.UserRepository;
import com.hidear.law.modular.model.User;
import com.hidear.law.modular.service.IUserService;
import com.hidear.law.modular.transfer.RegisterInfo;
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
    public User createUser(User user){

        return userRepository.save(user);
    }

    @Override
    public User createUser(RegisterInfo info){
        User user = getUserByInfo(info);
        return userRepository.save(user);
    }

    private User getUserByInfo(RegisterInfo info){
        User user = new User();
        user.setCoin(0.00);
        user.setPassword(info.getPassword());
        user.setPhoneNumber(info.getPhone());
        user.setNickname(info.getNickName());
        user.setUsername(info.getUsername());
        user.setStatus(UserStatus.OK.getCode());
        user.setRegisterTime(new Date());
        user.setSalt(ShiroKit.getRandomSalt(10));

        return user;
    }
}

