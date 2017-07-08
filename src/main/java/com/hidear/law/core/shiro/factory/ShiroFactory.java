package com.hidear.law.core.shiro.factory;

import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.util.SpringContextHolder;
import com.hidear.law.modular.user.dao.UserRepository;
import com.hidear.law.modular.user.model.User;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ShiroFactory implements IShiro{

    @Autowired
    UserRepository userRepository;

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public User user(String username) {

        User user = userRepository.findByUsername(username);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatus() != UserStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser= new ShiroUser();
        shiroUser.setUsername(user.getUsername());
        shiroUser.setAvatar(user.getAvatar());
        shiroUser.setCoin(user.getCoin());
        shiroUser.setNickname(user.getNickname());
        shiroUser.setPhone(user.getPhoneNumber());
        shiroUser.setTruename(user.getTruename());
        shiroUser.setLastLoginTime(user.getLastLoginTime());
        shiroUser.setUserType(user.getUserType());

        return shiroUser;

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
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }
}
