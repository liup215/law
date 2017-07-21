package com.hidear.law.modular.controller;

import com.hidear.law.common.constant.status.AreaStatus;
import com.hidear.law.common.constant.tip.ErrorTip;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.modular.dao.AreaRepository;
import com.hidear.law.modular.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    AreaRepository areaRepository;

    @RequestMapping(value="/child-of-{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Area> findChild(@PathVariable("id") Integer id){

        List<Area> areas = areaRepository.findByParentId(id);

        return areas;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Area areaIndex(@PathVariable("id") Integer id){
        Area area = areaRepository.findOne(id);

        return area;
    }

    @RequestMapping(value="/parent-of-{id}",method = RequestMethod.GET)
    @ResponseBody
    public Area areaParent(@PathVariable("id") Integer id){
        Area area = areaRepository.findParentArea(id);

        return area;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Tip addArea(Area area){
        try{
            areaRepository.save(area);
        }catch (Exception e){
            e.printStackTrace();
            throw new BussinessException(BizExceptionEnum.DB_WRITE_ERROR);
        }

        return new SuccessTip();
    }

    @RequestMapping(value="/delete-{id}",method = RequestMethod.GET)
    @ResponseBody
    public Tip addArea(@PathVariable("id") Integer id){

        try{
            Area area = areaRepository.findOne(id);
            if(area == null){
                return new ErrorTip(400,"该地区不存在");
            }

            if(area.getStatus()== AreaStatus.DELETED.getStatus()){
                return new ErrorTip(400,"该地区已经被禁用");
            }

            List<Area> childArea = areaRepository.findByParentIdAndStatus(id,AreaStatus.OK.getStatus());
            if(childArea.size()>0){
                return new ErrorTip(400,"该地区还有子地区处于启用状态，不能删除");
            }
            area.setStatus(AreaStatus.DELETED.getStatus());
        }catch (Exception e){
            e.printStackTrace();
            throw new BussinessException(BizExceptionEnum.DB_WRITE_ERROR);
        }

        return new SuccessTip();
    }
}
