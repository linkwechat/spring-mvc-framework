package com.linkwechat.spring.mvc.framework.exception;

/**
 * 返回类型
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
public enum ReturnType {
    SUCCESS(0, "业务成功"),
    FAIL(100, "业务失败"),
    UNKNOWN(200, "服务开了点小差，请稍后重试"),
    THIRD_PARTY_ERROR(300, "第三方异常"),
    SPRING_ERROR(400, "spring异常"),
    DB_ERROR(500, "DB异常");

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回描述
     */
    private String msg;

    ReturnType(Integer code, String type) {
        this.code = code;
        this.msg = type;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
