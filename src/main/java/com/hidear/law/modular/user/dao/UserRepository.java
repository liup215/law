package com.hidear.law.modular.user.dao;

import com.hidear.law.modular.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by acer on 2017/7/2.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    public User findByPhoneNumber(String PhoneNumber);
}
