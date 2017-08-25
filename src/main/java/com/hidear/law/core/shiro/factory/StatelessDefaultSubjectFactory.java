package com.hidear.law.core.shiro.factory;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * Created by Administrator on 2017/8/25.
 */
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {
    public Subject createSubject(SubjectContext context){
        //不创建session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
