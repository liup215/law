package com.hidear.law.modular.controller;

import com.hidear.law.common.constant.tip.ErrorTip;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.LogObjectHolder;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.modular.dao.UserRepository;
import com.hidear.law.modular.model.User;
import com.hidear.law.modular.transfer.PasswordModify;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public ShiroUser UserInfo(){
        ShiroUser user = ShiroKit.getUser();
//        if(user == null){
//            throw new AuthenticationException();
//        }

        return user;
    }

    @RequestMapping(value="/password_modify",method = RequestMethod.POST)
    @ResponseBody
    public Tip phoneModify(@Valid PasswordModify modify, BindingResult result){


        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error:errors){
                return new ErrorTip(400,error.getDefaultMessage());
            }
        }

        ShiroUser shiroUser = ShiroKit.getUser();
        if(!shiroUser.getPassword().equals(ShiroKit.md5(modify.getOldPassword(),shiroUser.getSalt()))){
            throw new BussinessException(BizExceptionEnum.ACCOUNT_FREEZED.OLD_PWD_NOT_RIGHT);
        }

        if(!modify.getNewPassword().equals(modify.getPasswordConfirm())){
            throw new BussinessException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }

        User user = userRepository.findOne(shiroUser.getId());
        user.setPassword(ShiroKit.md5(modify.getNewPassword(),user.getSalt()));
        userRepository.save(user);
        shiroUser.setPassword(user.getPassword());

        HttpKit.getRequest().getSession().setAttribute("shiroUser",shiroUser);

        return new SuccessTip();
    }

}
