package com.hidear.law.modular.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/1.
 */
@Controller
public class HomeController {

    @RequestMapping("/ss")
    @ResponseBody
    public Map<String,String> index(){
        Map<String,String> map = new HashMap<>();
        map.put("user","User");
        return map;
    }
}
