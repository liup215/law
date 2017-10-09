package com.hidear.law.modular.common.service.ServiceImpl;

import com.hidear.law.modular.common.model.SMSCode;
import com.hidear.law.modular.common.service.ISMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/9.
 */
@Service
public class SMSServiceImpl implements ISMSService{

    RestTemplate restTemplate=new RestTemplate();

    @Override
    public void sendCode(SMSCode smsCode) {

        try{
            String value = URLEncoder.encode("#code#="+smsCode.getCode(),"utf-8");
            String phone = smsCode.getPhone();
            String url = "http://v.juhe.cn/sms/send?mobile="+phone+"&tpl_id=46227&tpl_value="+value+"&key=fcf306275cda36e2df2db6e7f475db14";
            String res = restTemplate.getForObject(url,String.class);
            System.out.println(res);
        }catch (Exception e){
            System.out.println("短信发送失败");
        }

    }
}
