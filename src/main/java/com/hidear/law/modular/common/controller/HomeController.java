package com.hidear.law.modular.common.controller;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.Constants;
import com.hidear.law.common.annotion.AuthenticationCheck;
import com.hidear.law.common.constant.status.UserStatus;
import com.hidear.law.common.constant.tip.SuccessTip;
import com.hidear.law.common.constant.tip.Tip;
import com.hidear.law.common.exception.BizExceptionEnum;
import com.hidear.law.common.exception.BussinessException;
import com.hidear.law.common.exception.InvalidKaptchaException;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.log.factory.LogTaskFactory;
import com.hidear.law.core.shiro.ShiroKit;
import com.hidear.law.core.shiro.ShiroUser;
import com.hidear.law.core.support.HttpKit;
import com.hidear.law.core.token.TokenModel;
import com.hidear.law.core.token.config.AuthConstants;
import com.hidear.law.core.token.manager.TokenManager;
import com.hidear.law.core.util.ToolUtil;
import com.hidear.law.modular.User.dao.UserRepository;
import com.hidear.law.modular.User.model.User;
import com.hidear.law.modular.common.service.IHomeService;
import com.hidear.law.modular.common.service.ServiceImpl.HomeServiceImpl;
import com.hidear.law.modular.transfer.LoginTF;
import com.hidear.law.modular.transfer.RegisterTF;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/7/1.
 */
@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IHomeService homeService;

    @Autowired
    TokenManager tokenManager;

    /**
     * 项目首页
     * @return 返回首页
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(){

        return "/index.html";
    }

    /**
     * 项目首页，同"/"
     * @return
     */
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String home(){
        return "index.html";
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        String authorization = request.getHeader(AuthConstants.AUTHORIZATION);
        if(authorization != null){
            TokenModel model = tokenManager.getToken(authorization);
            if(tokenManager.checkToken(model)){
                return "redirect:/";
            }
        }
        return "/login.html";
    }

    /**
     * 登录,
     * @param loginTF 登录信息
     * @param result 格式验证结果
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Tip login(@Valid @RequestBody LoginTF loginTF, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError>  errors = result.getAllErrors();
            for(ObjectError error : errors){
                throw new BussinessException(400,error.getDefaultMessage());
            }
        }

        //验证验证码是否正确
        if(ToolUtil.getKaptchaOnOff()){
            String kaptcha = loginTF.getKaptcha();
            String code = (String) HttpKit.getRequest().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(ToolUtil.isEmpty(kaptcha) || !kaptcha.equals(code)){
                throw new InvalidKaptchaException();
            }
        }

        String username = loginTF.getPhoneNumber();
        String password = loginTF.getPassword();
        TokenModel token = homeService.login(username,password);

        return new SuccessTip(token);

    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(@RequestHeader("authorization") String authorization){
        homeService.logout(authorization);
        return "redirect:/login";
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(){
        return "/register.html";
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Tip register(@Valid @RequestBody RegisterTF registerTF, BindingResult result){

        //校验输入规则
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError error:list){
                throw new BussinessException(BizExceptionEnum.BAD_FORMATED);
            }
        }

        //校验验证码是否正确
        if(!registerTF.getVerifyCode().equals("111111")){
            throw new BussinessException(BizExceptionEnum.INVID_VERYFY_CODE);
        }

        //密码确认是否相同
        if(!registerTF.getPassword().equals(registerTF.getPasswordConfirm())){
            throw new BussinessException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }

        //手机号是否唯一
        if(userRepository.findByPhoneNumber(registerTF.getPhoneNumber())!=null){
            throw new BussinessException(BizExceptionEnum.USER_ALREADY_REG);
        }

        homeService.register(registerTF);
        return new SuccessTip();
    }

}
