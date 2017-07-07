package com.hidear.law.modular.user.service;

import com.hidear.law.core.util.MD5Util;
import com.hidear.law.modular.home.model.RegisterInfo;
import com.hidear.law.modular.home.model.SuccessTip;
import com.hidear.law.modular.user.dao.UserRepository;
import com.hidear.law.modular.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by acer on 2017/7/2.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    @Transactional
    public User createUser(User user){

        return userRepository.save(user);
    }
}
