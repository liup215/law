package com.hidear.law.core.shiro.factory;

import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.util.SpringContextHolder;
import com.hidear.law.modular.dao.UserRepository;
import com.hidear.law.modular.model.User;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactory implements IShiro {

    @Autowired
    private UserRepository userRepository;

    public static IShiro me() {

        return (SpringContextHolder.getBean(IShiro.class));
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
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setUsername(user.getUsername());// 账号


        return shiroUser;
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
