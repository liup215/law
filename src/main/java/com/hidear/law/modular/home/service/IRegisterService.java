package com.hidear.law.modular.home.service;

import com.hidear.law.modular.home.model.RegisterInfo;
import com.hidear.law.modular.home.model.RegisterTip;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface IRegisterService {

    public RegisterTip doRegister(RegisterInfo info);
}
