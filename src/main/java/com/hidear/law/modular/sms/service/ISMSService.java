package com.hidear.law.modular.sms.service;

import com.hidear.law.modular.sms.model.SMSCode;

/**
 * Created by Administrator on 2017/10/9.
 */
public interface ISMSService {

    public String sendCode(String phone,String ip);
}
