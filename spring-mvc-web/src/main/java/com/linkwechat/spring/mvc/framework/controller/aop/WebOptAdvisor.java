package com.linkwechat.spring.mvc.framework.controller.aop;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * web服务跟踪实现
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
@Component
@Aspect
public class WebOptAdvisor {
    private static final Logger logger = LoggerFactory.getLogger(WebOptAdvisor.class);

    @Around(value = "@annotation(com.linkwechat.spring.mvc.framework.controller.aop.WebOpt) && @annotation(opt)")
    public Object doAround(final ProceedingJoinPoint pjp, WebOpt opt) throws Throwable {
        long start = 0;
        long end = 0;

        // 统计起始时间
        if (opt.traceTime()) {
            start = System.currentTimeMillis();
        }

        // 修改线程名称为系统跟踪号
        if (opt.traceNo()) {
            Thread thread = Thread.currentThread();
            thread.setName(UUID.randomUUID().toString().replace("-", ""));
        }

        Object[] args = pjp.getArgs();
        Object ret = pjp.proceed(args);

        // 统计结束时间
        if (opt.traceTime()) {
            end = System.currentTimeMillis();
            logger.info("请求处理时间: " + (end - start) + "ms.");
        }
        return ret;
    }
}
