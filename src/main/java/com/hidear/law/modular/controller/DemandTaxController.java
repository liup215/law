package com.hidear.law.modular.controller;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.modular.dao.DemandTaxRepository;
import com.hidear.law.modular.model.DemandTax;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

@Controller
@RequestMapping("/demand/tax")
public class DemandTaxController {

    public static final String BasePath="/demand/tax";

    @Autowired
    DemandTaxRepository demandTaxRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String taxIndex(){
        return BasePath+"/tax.html";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<DemandTax> list(){
        List<DemandTax> list = demandTaxRepository.findAll();

        return list;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String taxAdd(){
        return BasePath+"/tax_add.html";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxAdd(DemandTax newTax){
        if(newTax==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        DemandTax tax = new DemandTax();
        BeanUtils.copyProperties(newTax,tax);
        tax.setStatus(1);
        tax.setSubmitTime((new Date().getTime()));
        tax.setUpdateTime((new Date().getTime()));

        demandTaxRepository.save(tax);

        return new SuccessTip();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxDelet(@RequestParam(required = false) Integer taxId){
        if(taxId==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        DemandTax tax = demandTaxRepository.findOne(taxId);
        tax.setStatus(0);
        demandTaxRepository.save(tax);
        return new SuccessTip();
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String taxUpdate(Integer taxId){
        if(taxId==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        return BasePath+"/tax_update.html";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxUpdate(DemandTax newTax){
        if(newTax==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        DemandTax tax = demandTaxRepository.findOne(newTax.getId());
        BeanUtils.copyProperties(newTax,tax);
        tax.setUpdateTime((new Date()).getTime());

        demandTaxRepository.save(tax);
        return new SuccessTip();
    }
}
