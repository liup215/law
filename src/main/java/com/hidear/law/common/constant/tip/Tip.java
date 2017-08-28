package com.hidear.law.common.constant.tip;

import java.util.Map;

/**
 * Created by acer on 2017/7/8.
 */
public abstract class Tip {
    protected int code;
    protected String message;
    protected Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
