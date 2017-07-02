package com.hidear.law.modular.user.service;

import com.hidear.law.modular.user.dao.UserRepository;
import com.hidear.law.modular.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer on 2017/7/2.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    public User saveUser(User user){
        userRepository.saveAndFlush(user);
        return user;
    }

    public List<User> getUserByUser(User user){
        Example example = Example.of(user);
        List<User> users= userRepository.findAll(example);
        return users;
    }
}
