package com.hidear.law.core.sms.factory;

import com.hidear.law.core.db.Db;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.modular.sms.dao.SMSCodeRepository;
import com.hidear.law.modular.sms.dao.SMSPluginRepository;
import com.hidear.law.modular.sms.model.SMSCode;
import com.hidear.law.modular.sms.model.SMSPlugin;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/10/11.
 */
public class SMSTaskFactory {

    public static RestTemplate restTemplate = new RestTemplate();

    public static SMSCodeRepository smsCodeRepository = Db.getRepository(SMSCodeRepository.class);
    public static SMSPluginRepository smsPluginRepository = Db.getRepository(SMSPluginRepository.class);

    public static TimerTask smsCode(String phone,String ip){
        return new TimerTask() {
            @Override
            public void run() {
                SMSCode smsCode = SMSFactory.getSMSCode(phone,ip);
                smsCodeRepository.save(smsCode);

                SMSPlugin smsPlugin = smsPluginRepository.findAll().get(0);
                try{
                    String value = URLEncoder.encode("#code#="+smsCode.getCode(),"utf-8");

                    String url = smsPlugin.getUrl()+"?mobile="+phone+"&tpl_id="+smsCode.getSmsTpl()+"&tpl_value="+value+"&key="+smsPlugin.getAppKey();
                    restTemplate.getForObject(url,String.class);
                    ShiroKit.getSession().setAttribute("code_"+smsCode.getPhone(),smsCode.getCode());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }
}
