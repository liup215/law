package com.hidear.law.modular.demand.controller;

import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.modular.demand.dao.DemandTaxRepository;
import com.hidear.law.modular.demand.model.DemandTax;
import com.hidear.law.modular.demand.service.IDemandService;
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
@RequestMapping("/tax")
public class DemandTaxController {

    public static final String BASE_PATH ="/tax";

    @Autowired
    DemandTaxRepository demandTaxRepository;

    @Autowired
    IDemandService taxDemandServiceImpl;

    /**
     * 获得需求列表
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(){

        return "redirect:"+BASE_PATH+"/list-1-50-id-DESC";
    }

    /**
     * 获得需求列表
     * @param pageNumber 页码
     * @param pageSize 每页条数
     * @param sortColumn 排序字段
     * @param sortType 排序类型
     * @return 返回List,前端解析为json数组
     */
    @RequestMapping(value = "/list-{pageNumber}-{pageSize}-{sortColumn}-{sortType}",method = RequestMethod.GET)
    public @ResponseBody List<DemandTax> listDemand(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize, @PathVariable(name="sortColumn") String sortColumn, @PathVariable(name="sortType") String sortType){

        List<DemandTax> list = null;
        Sort sort = new Sort(Sort.Direction.valueOf(sortType),sortColumn);
        Pageable page = new PageRequest(pageNumber-1,pageSize,sort);
        list = demandTaxRepository.findAll(page).getContent();
        return list;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public @ResponseBody List<DemandTax> list(@RequestBody TaxSearchTF taxSearchTF){
        List<DemandTax> list = null;

        if(taxSearchTF==null){
            list = demandTaxRepository.findAll();
            return list;
        }
        list = taxDemandServiceImpl.findDemandBySearch(taxSearchTF);
        return list;
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxAdd(@RequestBody DemandTax newTax){
        if(newTax==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        newTax.setStatus(1);
        newTax.setSubmitTime((new Date().getTime()));
        newTax.setUpdateTime((new Date().getTime()));
        newTax.setVisitCount(0);
        demandTaxRepository.save(newTax);

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

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public Tip taxUpdate(@RequestBody DemandTax newTax){
        if(newTax==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        newTax.setUpdateTime((new Date()).getTime());


        demandTaxRepository.save(newTax);
        return new SuccessTip();
    }

}
