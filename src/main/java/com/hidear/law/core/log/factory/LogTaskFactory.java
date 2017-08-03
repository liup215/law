package com.hidear.law.core.log.factory;

import com.hidear.law.common.constant.status.LogSucceed;
import com.hidear.law.common.constant.status.LogType;
import com.hidear.law.core.db.Db;
import com.hidear.law.core.log.LogManager;
import com.hidear.law.core.util.ToolUtil;
import com.hidear.law.modular.common.dao.LoginLogRepository;
import com.hidear.law.modular.common.dao.OperationRepository;
import com.hidear.law.modular.common.model.LoginLog;
import com.hidear.law.modular.common.model.OperationLog;
import org.apache.log4j.Logger;

import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 *
 * @author fengshuonan
 * @date 2016年12月6日 下午9:18:27
 */
public class LogTaskFactory {

    private static Logger logger = Logger.getLogger(LogManager.class);
    private static LoginLogRepository loginLogRepository = Db.getRepository(LoginLogRepository.class);
    private static OperationRepository operationRepository = Db.getRepository(OperationRepository.class);

    public static TimerTask loginLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogRepository.save(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogRepository.save(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null,ip);
                try {
                    loginLogRepository.save(loginLog);
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

//    public static TimerTask bussinessLog(final Integer userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
//        return new TimerTask() {
//            @Override
//            public void run() {
//                OperationLog operationLog = LogFactory.createOperationLog(
//                        LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
//                try {
//                    operationLogMapper.insert(operationLog);
//                } catch (Exception e) {
//                    logger.error("创建业务日志异常!", e);
//                }
//            }
//        };
//    }
//
    public static TimerTask exceptionLog(final Integer userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = ToolUtil.getExceptionMsg(exception);
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.EXCEPTION, userId, "", null, null, msg, LogSucceed.FAIL);
                try {
                    operationRepository.save(operationLog);
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }
}
