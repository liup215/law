package com.hidear.law.modular.service;

import com.hidear.law.modular.model.User;
import com.hidear.law.modular.transfer.RegisterInfo;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface IUserService {

    public User createUser(User user);

    public User createUser(RegisterInfo info);
}
