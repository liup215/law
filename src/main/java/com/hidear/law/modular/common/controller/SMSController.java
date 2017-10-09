package com.hidear.law.modular.common.controller;

import com.hidear.law.common.constant.status.SMSCodeStatus;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.modular.common.dao.SMSCodeRepository;
import com.hidear.law.modular.common.dao.SMSTemplateRepository;
import com.hidear.law.modular.common.model.SMSCode;
import com.hidear.law.modular.common.model.SMSTemplate;
import com.hidear.law.modular.common.service.ISMSService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/9.
 */
@Controller
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    SMSCodeRepository smsCodeRepository;

    @Autowired
    SMSTemplateRepository smsTemplateRepository;

    @Autowired
    ISMSService smsService;

    @RequestMapping(value="/getCode",method = RequestMethod.GET)
    @ResponseBody
    public Tip getCode(@RequestParam(name="phone") String phone, HttpServletRequest request){
        String code = getSix();
        String ip = request.getRemoteAddr();

        SMSCode smsCode = new SMSCode();
        smsCode.setPhone(phone);
        smsCode.setCode(code);
        smsCode.setIp(ip);
        smsCode.setAskTime((new Date()).getTime());
        smsCode.setStatus(SMSCodeStatus.UNUSED.getStatus());

        smsCodeRepository.save(smsCode);
        smsService.sendCode(smsCode);
        ShiroKit.getSession().setAttribute(phone+"code",smsCode.getCode());

        return new SuccessTip(200,"验证码发送成功");
    }

    public static String getSix(){
        Random rad=new Random();

        String result  = rad.nextInt(1000000) +"";

        if(result.length()!=6){
            return getSix();
        }
        return result;
    }
}
