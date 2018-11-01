package com.linkwechat.spring.mvc.framework.controller.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.linkwechat.spring.mvc.framework.vo.BizResponse;

/**
 * 全局异常处理
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(Exception e) {
        BizResponse bizResponse = new BizResponse(e);
        logger.error("未捕获的全局异常: " + e);
        return bizResponse.toString();
    }
}
