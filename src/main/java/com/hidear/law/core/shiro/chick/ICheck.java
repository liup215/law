package com.hidear.law.core.shiro.chick;

/**
 * Created by Administrator on 2017/7/1.
 */
public interface ICheck {
    boolean check(Object[] permissions);
    boolean checkAll();
}
