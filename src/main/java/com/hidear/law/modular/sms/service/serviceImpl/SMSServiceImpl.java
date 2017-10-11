package com.hidear.law.modular.sms.service.serviceImpl;

import com.hidear.law.core.sms.SMSManager;
import com.hidear.law.core.sms.factory.SMSTaskFactory;
import com.hidear.law.modular.sms.service.ISMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/10/9.
 */
@Service
public class SMSServiceImpl implements ISMSService{

    @Override
    public String sendCode(String phone,String ip) {

        SMSManager.me().executeSMS(SMSTaskFactory.smsCode(phone,ip));
        return "短信已经发送，请查收";
    }
}
