package com.hidear.law.modular.controller;

import com.hidear.law.modular.dao.CaseTaxRepository;
import com.hidear.law.modular.model.DemandTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

@Controller
@RequestMapping("/case")
public class CaseController {

    @Autowired
    CaseTaxRepository caseTaxRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String caseIndex(){
        return "/case/index.html";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<DemandTax> list(){
        List<DemandTax> list = caseTaxRepository.findAll();

        if(list!=null && list.size()>0){
            return list;
        }
        for(int i=0;i<10;i++){
            DemandTax tax = new DemandTax();
            tax.setId(i);
            list.add(tax);
        }

        return list;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String caseAdd(){
        return "/case/case_add.html";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String caseAdd(DemandTax tax){
        tax.setStatus(1);
        tax.setSubmitTime((new Date().getTime()));
        tax.setUpdateTime((new Date().getTime()));

        caseTaxRepository.save(tax);

        return "需求添加成功";
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String caseDelet(){
        return "/case/case_delete.html";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String caseDelet(Integer id){

        DemandTax tax = caseTaxRepository.findOne(id);
        tax.setStatus(0);
        caseTaxRepository.save(tax);
        return "信息删除成功";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String caseUpdate(){
        return "/case/case_update.html";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public String caseUpdate(DemandTax tax){
        DemandTax oldTax = caseTaxRepository.findOne(tax.getId());
        oldTax.setArea(tax.getArea());
        oldTax.setAssets(tax.getAssets());
        oldTax.setCaseDetail(tax.getCaseDetail());
        oldTax.setContact(tax.getContact());
        oldTax.setIndustry(tax.getIndustry());
        oldTax.setName(tax.getName());
        oldTax.setOutput(tax.getOutput());
        oldTax.setPhone(tax.getPhone());
        oldTax.setPost(tax.getPost());
        oldTax.setScale(tax.getScale());
        oldTax.setWorkType(tax.getWorkType());

        caseTaxRepository.save(oldTax);
        return "更新成功！！！";
    }
}
