package com.hidear.law.modular.common.service;

import com.hidear.law.core.token.TokenModel;
import com.hidear.law.modular.transfer.RegisterTF;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/25.
 */
public interface IHomeService {
    public TokenModel login(String username, String password);
    public void register(RegisterTF registerTF);
    public void logout(String authorization);
    public boolean loginCheck(String authorization);
}
