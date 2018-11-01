package com.linkwechat.spring.mvc.framework.controller.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * web服务跟踪
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebOpt {

    /**
     * 交易时间统计
     * 
     * @return boolean
     */
    boolean traceTime() default true;

    /**
     * 交易跟踪号生成
     * 
     * @return boolean
     */
    boolean traceNo() default true;
}
