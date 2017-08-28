package com.hidear.law.modular.User.controller;

import com.hidear.law.common.annotion.AuthenticationCheck;
import com.hidear.law.common.constant.tip.ErrorTip;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.config.properties.LawProperties;

import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.shiro.factory.ShiroFactory;
import com.hidear.law.core.support.HttpKit;

import com.hidear.law.core.token.config.AuthConstants;
import com.hidear.law.modular.User.dao.UserRepository;
import com.hidear.law.modular.User.model.User;
import com.hidear.law.modular.User.service.IUserService;
import com.hidear.law.modular.common.service.ServiceImpl.HomeServiceImpl;
import com.hidear.law.modular.transfer.PasswordModify;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017/7/14.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Resource
    private LawProperties lawProperties;

    @Autowired
    IUserService userService;

    /**
     * 获得登录用户资料
     * @return
     */
    @RequestMapping(value="/info",method = RequestMethod.GET)
    @ResponseBody
    @AuthenticationCheck
    public ShiroUser UserInfo(@RequestHeader(name = AuthConstants.AUTHORIZATION) String authorization){

        ShiroUser shiroUser = userService.userInfo(authorization);

        if(shiroUser == null){
            throw new AuthenticationException();
        }

        return shiroUser;
    }

    /**
     * 修改密码
     * @param modify 修改密码时提交的必要信息
     * @param result 修改结果
     * @return
     */
    @RequestMapping(value="/password_edit",method = RequestMethod.POST)
    @ResponseBody
    @AuthenticationCheck
    public Tip passwordModify(@Valid @RequestBody PasswordModify modify, BindingResult result,@RequestHeader(name = AuthConstants.AUTHORIZATION) String authorization){
        //判断密码是否正确
        ShiroUser shiroUser = userService.userInfo(authorization);
        if(!shiroUser.getPassword().equals(ShiroKit.md5(modify.getOldPassword(),shiroUser.getSalt()))){
            throw new BussinessException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
        //提交信息格式验证
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error:errors){
                return new ErrorTip(400,error.getDefaultMessage());
            }
        }
        //新密码和旧密码是否相同
        if(!modify.getNewPassword().equals(modify.getPasswordConfirm())){
            throw new BussinessException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }

        //验证通过，更新密码
        User user = userRepository.findOne(shiroUser.getId());
        user.setPassword(ShiroKit.md5(modify.getNewPassword(),user.getSalt()));
        userRepository.save(user);

        //存储session
        shiroUser.setPassword(user.getPassword());
        HttpKit.getRequest().getSession().setAttribute("shiroUser",shiroUser);

        return new SuccessTip();
    }

    /**
     * 会员信息修改，只能修改昵称和头像
     * @param newUser
     * @param userId
     * @return
     */
    @RequestMapping(value="/info_edit")
    @ResponseBody
    @AuthenticationCheck
    public Tip userNameEdit(@RequestBody User newUser,@RequestHeader(name = AuthConstants.AUTHORIZATION) String authorization){
        ShiroUser shiroUser = userService.userInfo(authorization);
        User user = userRepository.findOne(shiroUser.getId());
        user.setNickname(newUser.getNickname());
        user.setAvatar(newUser.getAvatar());
        userRepository.save(user);
        return new SuccessTip();
    }

    /**
     * 单文件上传
     * @param file 文件参数，名称为"file"
     * @return 返回操作结果
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    @AuthenticationCheck
    public Tip upload(@RequestParam(name = "file") MultipartFile file) {

        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
            String fileSavePath = lawProperties.getFileUploadPath();
            file.transferTo(new File(fileSavePath + pictureName));
            Map<String,Object> data = new HashedMap();
            data.put("file",fileSavePath+pictureName);
            return new SuccessTip(data);
        } catch (Exception e) {
            throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
        }

    }
}
