package com.hidear.law.modular.user.service.serviceImpl;

import com.hidear.law.modular.user.dao.UserRepository;
import com.hidear.law.modular.user.model.User;
import com.hidear.law.modular.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
