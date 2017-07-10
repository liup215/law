package com.hidear.law.core.shiro.factory;

import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.modular.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface IShiro {

    /**
     * 根据账号获取登录用户
     *
     * @param username 账号
     */
    User user(String username);

    /**
     * 根据系统用户获取Shiro的用户
     *
     * @param user 系统用户
     */
    ShiroUser shiroUser(User user);


    /**
     * 获取shiro的认证信息
     */
    SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName);
}
