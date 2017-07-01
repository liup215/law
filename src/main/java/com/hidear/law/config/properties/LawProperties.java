package com.hidear.law.config.properties;

import static com.hidear.law.core.util.ToolUtil.isEmpty;
import static com.hidear.law.core.util.ToolUtil.getTempPath;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Administrator on 2017/7/1.
 */

@Component
@ConfigurationProperties(prefix = LawProperties.PREFIX)
public class LawProperties {
    public static final String PREFIX="law";
    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    private Integer sessionInvalidateTime = 30 * 60;  //session 失效时间（默认为30分钟 单位：秒）

    private Integer sessionValidationInterval = 15 * 60;  //session 验证失效时间（默认为15分钟 单位：秒）

    public String getFileUploadPath(){

        //如果没有写文件上传路径，保存到临时文件
        if(isEmpty(fileUploadPath)){
            return getTempPath();
        }else{
            //判断有没有结尾符，没有得加上
            if(!fileUploadPath.endsWith(File.separator)){
                fileUploadPath=fileUploadPath+File.separator;
            }
            //判断目录是否存在，不存在得加上
            if(haveCreatePath == false){
                File file= new File(fileUploadPath);
                file.mkdirs();
                haveCreatePath=true;
            }
            return fileUploadPath;

        }
    }

    public Boolean getKaptchaOpen() {
        return kaptchaOpen;
    }

    public void setKaptchaOpen(Boolean kaptchaOpen) {
        this.kaptchaOpen = kaptchaOpen;
    }

    public Boolean getSwaggerOpen() {
        return swaggerOpen;
    }

    public void setSwaggerOpen(Boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Integer getSessionInvalidateTime() {
        return sessionInvalidateTime;
    }

    public void setSessionInvalidateTime(Integer sessionInvalidateTime) {
        this.sessionInvalidateTime = sessionInvalidateTime;
    }

    public Integer getSessionValidationInterval() {
        return sessionValidationInterval;
    }

    public void setSessionValidationInterval(Integer sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }
}
