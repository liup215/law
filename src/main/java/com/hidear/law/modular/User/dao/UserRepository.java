package com.hidear.law.modular.User.dao;

import com.hidear.law.modular.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by acer on 2017/7/2.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    public User findByPhoneNumber(String PhoneNumber);

    public User findByUsername(String username);
}
