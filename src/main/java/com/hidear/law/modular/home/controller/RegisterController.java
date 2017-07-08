package com.hidear.law.modular.home.controller;

import com.hidear.law.modular.home.model.RegisterInfo;
import com.hidear.law.modular.home.model.RegisterTip;
import com.hidear.law.modular.home.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class RegisterController {

    @Autowired
    IRegisterService service;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/register.html";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody Object register(RegisterInfo info){

        RegisterTip tip = service.doRegister(info);

        return tip;
    }


}
