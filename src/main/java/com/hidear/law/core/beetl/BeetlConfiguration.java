package com.hidear.law.core.beetl;

import com.hidear.law.core.util.ToolUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

	@Override
	public void initOther() {

		groupTemplate.registerFunctionPackage("tool", new ToolUtil());

	}

}
