package com.hidear.law.modular.home.controller;

import com.hidear.law.modular.home.model.RegisterInfo;
import com.hidear.law.modular.home.model.SuccessTip;
import com.hidear.law.modular.home.service.RegisterService;
import com.hidear.law.modular.user.model.User;
import com.hidear.law.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class RegisterController {

    @Autowired
    RegisterService service;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/register.html";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody Object register(RegisterInfo info){

        SuccessTip tip = (SuccessTip) service.doRegister(info);
        return tip;
    }


}
