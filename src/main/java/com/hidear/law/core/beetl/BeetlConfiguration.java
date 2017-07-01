package com.hidear.law.core.beetl;

import com.hidear.law.core.util.ToolUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * Created by Administrator on 2017/7/1.
 */


public class BeetlConfiguration extends BeetlGroupUtilConfiguration{
    @Override
    public void initOther(){
        groupTemplate.registerFunctionPackage("shiro",new ShiroExt());
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
    }
}
