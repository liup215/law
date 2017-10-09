package com.hidear.law.modular.common.service;

import com.hidear.law.modular.common.model.SMSCode;

/**
 * Created by Administrator on 2017/10/9.
 */
public interface ISMSService {

    public void sendCode(SMSCode code);
}
