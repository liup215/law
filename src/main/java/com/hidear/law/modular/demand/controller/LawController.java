package com.hidear.law.modular.demand.controller;

import com.hidear.law.common.annotion.AuthenticationCheck;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.core.support.BeanKit;
import com.hidear.law.core.util.ToolUtil;
import com.hidear.law.modular.demand.dao.DemandLawRepository;
import com.hidear.law.modular.demand.model.DemandLaw;
import com.hidear.law.modular.transfer.LawSearchTF;
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
 * Created by Administrator on 2017/7/12.
 */

@Controller
@RequestMapping("/law")
public class LawController {

    public static final String BASE_PATH = "/law";

    @Autowired
    public DemandLawRepository demandLawRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
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
    @ResponseBody
    public Tip list(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize, @PathVariable(name="sortColumn") String sortColumn, @PathVariable(name="sortType") String sortType){
        List<DemandLaw> list = null;

        Sort sort = new Sort(Sort.Direction.valueOf(sortType),sortColumn);
        Pageable page = new PageRequest(pageNumber-1,pageSize,sort);
        list = demandLawRepository.findAll(page).getContent();
        return new SuccessTip(list);
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Tip list(LawSearchTF lawSearchTF){

        return new SuccessTip(demandLawRepository.findAll());
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @AuthenticationCheck
    public Tip add(DemandLaw newLaw){
        if(newLaw==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        newLaw.setStatus(1);
        newLaw.setSubmitTime((new Date().getTime()));
        newLaw.setUpdateTime((new Date().getTime()));


        demandLawRepository.save(newLaw);
        return new SuccessTip();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    @AuthenticationCheck
    public Tip add(@RequestParam(name = "lawId") Integer lawId){
        if(lawId==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        DemandLaw law = demandLawRepository.findOne(lawId);
        law.setStatus(0);
        demandLawRepository.save(law);
        return new SuccessTip();
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @AuthenticationCheck
    public Tip update(@RequestBody DemandLaw newLaw){
        if(newLaw==null){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        newLaw.setUpdateTime((new Date()).getTime());
        demandLawRepository.save(newLaw);

        return new SuccessTip();
    }

    @RequestMapping(value="/detail/{lawId}")
    @ResponseBody
    @AuthenticationCheck
    public Tip taxDetail(@PathVariable Integer lawId){
        if(ToolUtil.isEmpty(lawId)){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        DemandLaw law = demandLawRepository.findOne(lawId);
        return new SuccessTip(BeanKit.beanToMap(law));
    }

}
