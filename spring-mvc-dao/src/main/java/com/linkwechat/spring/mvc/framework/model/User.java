package com.linkwechat.spring.mvc.framework.model;

/**
 * 用户实体
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
public class User {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户手机号
     */
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
