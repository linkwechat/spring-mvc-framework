package com.linkwechat.spring.mvc.framework.exception;

/**
 * 业务异常
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private final Integer errorCode;

    /**
     * 错误描述
     */
    private final String msg;

    /**
     * 附加数据
     */
    private final String data;

    public BizException(Integer errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = null;
    }

    public BizException(Integer errorCode, String msg, String data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public BizException(ReturnType returnType) {
        this.errorCode = returnType.getCode();
        this.msg = returnType.getMsg();
        this.data = null;
    }

    public BizException(ReturnType returnType, String data) {
        this.errorCode = returnType.getCode();
        this.msg = returnType.getMsg();
        this.data = data;
    }

    public BizException(ReturnType returnType, Exception e) {
        this.errorCode = returnType.getCode();
        this.msg = returnType.getMsg();
        this.data = e.getMessage();
        this.setStackTrace(e.getStackTrace());
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public String getData() {
        return data;
    }
}
