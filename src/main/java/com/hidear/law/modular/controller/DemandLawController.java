package com.hidear.law.modular.controller;

import com.hidear.law.modular.dao.DemandLawRepository;
import com.hidear.law.modular.model.DemandLaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

@Controller
@RequestMapping("/demand/law")
public class DemandLawController {

    public static final String BASE_PATH = "/demand/law";

    @Autowired
    public DemandLawRepository demandLawRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return BASE_PATH+"/law.html";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<DemandLaw> list(){
        return demandLawRepository.findAll();
    }

    @RequestMapping(value = "/list_condition",method = RequestMethod.GET)
    @ResponseBody
    public List<DemandLaw> list(DemandLaw law){

        Example<DemandLaw> lawExample = Example.of(law);
        return demandLawRepository.findAll(lawExample);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return BASE_PATH+"/law_add.html";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(DemandLaw law){
        demandLawRepository.save(law);
        return BASE_PATH+"/law_add.html";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String add(Integer id){
        DemandLaw law = demandLawRepository.findOne(id);
        law.setStatus(0);
        return "delete succeed";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(Integer id){
        return BASE_PATH+"/law_update.html";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(DemandLaw newLaw){
        DemandLaw law = demandLawRepository.findOne(newLaw.getId());
        //设置新条件信息

        return "update succeed";

    }

}
