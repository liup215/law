package com.hidear.law.core.sms;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/10/11.
 */
public class SMSManager {

    private final int OPERATE_DELAY_TIME = 0;
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private SMSManager(){

    };

    public static SMSManager smsManager = new SMSManager();

    public static SMSManager me(){
        return smsManager;
    }

    public void executeSMS(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    };
}
