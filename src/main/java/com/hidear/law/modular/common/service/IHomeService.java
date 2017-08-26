package com.hidear.law.modular.common.service;

import com.hidear.law.modular.transfer.RegisterTF;

/**
 * Created by Administrator on 2017/8/25.
 */
public interface IHomeService {
    public String login(String username,String password);
    public void register(RegisterTF registerTF);
}
