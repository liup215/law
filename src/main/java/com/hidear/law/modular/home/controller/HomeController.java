package com.hidear.law.modular.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/1.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(){
        return "/index.html";
    }
}
