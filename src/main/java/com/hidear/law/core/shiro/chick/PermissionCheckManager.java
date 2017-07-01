package com.hidear.law.core.shiro.chick;

import com.hidear.law.core.util.SpringContextHolder;

/**
 * Created by Administrator on 2017/7/1.
 */
public class PermissionCheckManager {
    private final static PermissionCheckManager me = new PermissionCheckManager();

    private ICheck defaultCheckFactory = SpringContextHolder.getBean(ICheck.class);

    public static PermissionCheckManager me() {
        return me;
    }

    private PermissionCheckManager() {
    }

    public PermissionCheckManager(ICheck checkFactory) {
        this.defaultCheckFactory = checkFactory;
    }

    public void setDefaultCheckFactory(ICheck defaultCheckFactory) {
        this.defaultCheckFactory = defaultCheckFactory;
    }

    public static boolean check(Object[] permissions) {
        return me.defaultCheckFactory.check(permissions);
    }

    public static boolean checkAll() {
        return me.defaultCheckFactory.checkAll();
    }
}
