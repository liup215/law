package com.hidear.law.core.shiro.factory;

import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.util.SpringContextHolder;
import com.hidear.law.modular.user.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ShiroFactory implements IShiro{

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public User user(String account) {
        return null;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        return null;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        return null;
    }
}
