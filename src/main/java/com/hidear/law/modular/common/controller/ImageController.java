package com.hidear.law.modular.common.controller;

import com.hidear.law.common.annotion.AuthenticationCheck;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.config.properties.LawProperties;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.support.StrKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.apache.shiro.authc.AuthenticationException;
import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/17.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    @Resource
    private LawProperties lawProperties;

    @RequestMapping("")
    public String file(){
        return "/image.html";
    }

    /**
     * 单文件上传
     * @param file 文件参数，名称为"file"
     * @return 返回操作结果
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @AuthenticationCheck
    @ResponseBody
    public Tip upload(@RequestParam(name = "file") MultipartFile file,@RequestHeader("authorization") String authorization) {

        ShiroUser user = (ShiroUser) HttpKit.getRequest().getSession().getAttribute("shiroUser");
        String userPath = null;
        if(user == null){
//            throw new AuthenticationException();
            userPath = "default";
        }else{
            userPath = user.getPhoneNumber();
        }

        String fileType = StrKit.subSuf(file.getOriginalFilename(),".");
        String fileSavePath = lawProperties.getFileUploadPath();

        File folder = new File(fileSavePath + userPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String pictureName = UUID.randomUUID().toString() + fileType;
        try {
            file.transferTo(new File(fileSavePath + userPath + File.separator + pictureName));
            Map<String,Object> data = new HashMap();
            data.put("file", userPath + "/" + pictureName);
            return new SuccessTip(data);
        } catch (Exception e) {
            throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
        }

    }
}
