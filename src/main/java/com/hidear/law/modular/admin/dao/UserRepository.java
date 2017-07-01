package com.hidear.law.modular.admin.dao;

import com.hidear.law.modular.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/1.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByAccount(String account);
}
