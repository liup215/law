package com.hidear.law.modular.sms.controller;

import com.hidear.law.common.constant.status.SMSCodeStatus;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.modular.sms.dao.SMSCodeRepository;
import com.hidear.law.modular.sms.dao.SMSTemplateRepository;
import com.hidear.law.modular.sms.service.ISMSService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
        String ip = request.getRemoteAddr();

        String res = smsService.sendCode(phone,ip);

        return new SuccessTip(res);
    }


}
