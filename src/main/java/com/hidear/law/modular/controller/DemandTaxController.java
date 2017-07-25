package com.hidear.law.modular.controller;

import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.modular.dao.DemandTaxRepository;
import com.hidear.law.modular.model.DemandTax;
import com.hidear.law.modular.service.IDemandService;
import com.hidear.law.modular.transfer.TaxSearchTF;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

@Controller
@RequestMapping("/demand/tax")
public class DemandTaxController {

    public static final String BASE_PATH ="/demand/tax";

    @Autowired
    DemandTaxRepository demandTaxRepository;

    @Autowired
    IDemandService taxDemandServiceImpl;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String taxIndex(){
        return BASE_PATH +"/tax.html";
    }

    /**
     * 获得需求列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(){

        return "redirect:"+BASE_PATH+"/find-1-50-id-ASC";
    }

    /**
     * 获得需求列表
     * @param pageNumber 页码
     * @param pageSize 每页条数
     * @param sortColumn 排序字段
     * @param sortType 排序类型
     * @return 返回List,前端解析为json数组
     */
    @RequestMapping(value = "/find-{pageNumber}-{pageSize}-{sortColumn}-{sortType}",method = RequestMethod.GET)
    public @ResponseBody List<DemandTax> listDemand(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize, @PathVariable(name="sortColumn") String sortColumn, @PathVariable(name="sortType") String sortType){

        List<DemandTax> list = null;
        Sort sort = new Sort(Sort.Direction.valueOf(sortType),sortColumn);
        Pageable page = new PageRequest(pageNumber-1,pageSize,sort);
        list = demandTaxRepository.findAll(page).getContent();
        return list;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public @ResponseBody List<DemandTax> list(TaxSearchTF taxSearchTF){
        List<DemandTax> list = null;

        if(taxSearchTF==null){
            list = demandTaxRepository.findAll();
            return list;
        }
        list = taxDemandServiceImpl.findDemandBySearch(taxSearchTF);
        return list;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String taxAdd(){
        return BASE_PATH +"/tax_add.html";
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
        tax.setVisitCount(0);
        demandTaxRepository.save(tax);

        return new SuccessTip();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxDelet(@RequestParam(name = "taxId") Integer taxId){

        DemandTax tax = demandTaxRepository.findOne(taxId);
        if(tax==null){
            throw new BussinessException(BizExceptionEnum.DB_RESOURCE_NULL);
        }

        tax.setStatus(0);
        demandTaxRepository.save(tax);
        return new SuccessTip();
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String taxUpdate(){
        return BASE_PATH +"/tax_update.html";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxUpdate(DemandTax newTax){
        if(newTax==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        DemandTax tax = demandTaxRepository.findOne(newTax.getId());
        if(newTax.getName()!=null && !newTax.getName().equals("")){
            tax.setName(newTax.getName());
        }

        if(newTax.getContact()!=null && !newTax.getContact().equals("")){
            tax.setContact(newTax.getContact());
        }
        if(newTax.getPhoneNumber()!=null && !newTax.getPhoneNumber().equals("")){
            tax.setName(newTax.getName());
        }
        if(newTax.getScale()!=null && !newTax.getScale().equals("")){
            tax.setScale(newTax.getScale());
        }
        if(newTax.getAssets()!=null && !newTax.getAssets().equals("")){
            tax.setAssets(newTax.getAssets());
        }
        if(newTax.getOutput()!=null && !newTax.getOutput().equals("")){
            tax.setOutput(newTax.getOutput());
        }
        if(newTax.getWorkSpace()!=null && !newTax.getWorkSpace().equals("")){
            tax.setWorkSpace(newTax.getWorkSpace());
        }
        if(newTax.getIndustry()!=null && !newTax.getIndustry().equals("")){
            tax.setIndustry(newTax.getIndustry());
        }
        if(newTax.getCaseDetail()!=null && !newTax.getCaseDetail().equals("")){
            tax.setCaseDetail(newTax.getCaseDetail());
        }
        if(newTax.getWorkType()!=null){
            tax.setContactAddress(newTax.getContactAddress());
        }
        if(newTax.getPost()!=null){
            tax.setPost(newTax.getPost());
        }
        tax.setUpdateTime((new Date()).getTime());


        demandTaxRepository.save(tax);
        return new SuccessTip();
    }

    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search(){
        return BASE_PATH+"/tax_search.html";
    }
}
