package com.linkwechat.spring.mvc.framework.vo;

import com.linkwechat.commons.util.JsonUtils;
import com.linkwechat.spring.mvc.framework.exception.BizException;
import com.linkwechat.spring.mvc.framework.exception.ReturnType;

/**
 * 业务响应数据
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
public class BizResponse {

    /**
     * 返回码
     */
    private Integer errorCode;

    /**
     * 返回描述
     */
    private String msg;

    /**
     * 响应数据
     */
    private String values;

    public BizResponse(ReturnType returnType) {
        this.errorCode = returnType.getCode();
        this.msg = returnType.getMsg();
    }

    public BizResponse(ReturnType returnType, String data) {
        this.errorCode = returnType.getCode();
        this.msg = returnType.getMsg();
        this.values = data;
    }

    public BizResponse(Exception e) {
        if (e instanceof BizException) {
            BizException be = (BizException) e;
            this.errorCode = be.getErrorCode();
            this.msg = be.getMsg();
            this.values = be.getData();
        } else {
            this.errorCode = ReturnType.UNKNOWN.getCode();
            this.msg = ReturnType.UNKNOWN.getMsg();
            this.values = e.getMessage();
        }
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public String getValues() {
        return values;
    }

    @Override
    public String toString() {
        return JsonUtils.getStandardJsonString(this);
    }
}
