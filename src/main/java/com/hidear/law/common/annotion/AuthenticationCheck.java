package com.hidear.law.common.annotion;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/8/26.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuthenticationCheck {
}
