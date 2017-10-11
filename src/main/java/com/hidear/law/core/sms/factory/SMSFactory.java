package com.hidear.law.core.sms.factory;

import com.hidear.law.common.constant.status.SMSCodeStatus;
import com.hidear.law.common.constant.status.SMSType;
import com.hidear.law.core.db.Db;
import com.hidear.law.modular.sms.dao.SMSTemplateRepository;
import com.hidear.law.modular.sms.model.SMSCode;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/11.
 */
public class SMSFactory {

    private static SMSTemplateRepository smsTemplateRepository = Db.getRepository(SMSTemplateRepository.class);

    public static SMSCode getSMSCode(String phone,String ip){
        SMSCode smsCode = new SMSCode();
        smsCode.setPhone(phone);
        smsCode.setCode(getCode());
        smsCode.setStatus(SMSCodeStatus.UNUSED.getStatus());
        smsCode.setAskTime((new Date()).getTime());
        smsCode.setIp(ip);
        smsCode.setSmsTpl(smsTemplateRepository.findByType(SMSType.VerifyCode.getType()).getCode());
        return smsCode;
    }

    public static String getCode(){
        Random rad=new Random();

        String result  = rad.nextInt(1000000) +"";

        if(result.length()!=6){
            return getCode();
        }
        return result;
    }
}
