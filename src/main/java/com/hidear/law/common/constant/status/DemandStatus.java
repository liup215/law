package com.hidear.law.common.constant.status;

/**
 * Created by Administrator on 2017/7/14.
 */
public enum DemandStatus {

    OK(1,"上架中"),DELETE(0,"已下架");

    private Integer friendlyCode;
    private String friendlyMsg;

    DemandStatus(Integer friendlyCode, String friendlyMsg) {
        this.friendlyCode = friendlyCode;
        this.friendlyMsg = friendlyMsg;
    }

    public Integer getFriendlyCode() {
        return friendlyCode;
    }

    public void setFriendlyCode(Integer friendlyCode) {
        this.friendlyCode = friendlyCode;
    }

    public String getFriendlyMsg() {
        return friendlyMsg;
    }

    public void setFriendlyMsg(String friendlyMsg) {
        this.friendlyMsg = friendlyMsg;
    }
}
