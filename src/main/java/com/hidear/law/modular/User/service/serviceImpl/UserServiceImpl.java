package com.hidear.law.modular.User.service.serviceImpl;

import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.shiro.factory.ShiroFactory;
import com.hidear.law.core.token.TokenModel;
import com.hidear.law.core.token.manager.TokenManager;
import com.hidear.law.modular.User.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/28.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    TokenManager tokenManager;

    @Override
    public ShiroUser userInfo(String authorization) {
        TokenModel token = tokenManager.getToken(authorization);
        Integer userId = token.getUserId();
        ShiroUser shiroUser = ShiroFactory.me().shiroUser(userId);

        return shiroUser;
    }
}
