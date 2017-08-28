package com.hidear.law.modular.User.service;

import com.hidear.law.core.shiro.ShiroUser;

/**
 * Created by Administrator on 2017/8/28.
 */
public interface IUserService {

    public ShiroUser userInfo(String authorization);
}
