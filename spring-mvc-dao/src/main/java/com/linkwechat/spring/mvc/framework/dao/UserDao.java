package com.linkwechat.spring.mvc.framework.dao;

import com.linkwechat.spring.mvc.framework.model.User;

/**
 * 用户数据层接口
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
public interface UserDao {
    /**
     * 通过用户id获取用户信息
     * 
     * @param id
     *            用户id
     * @return User
     */
    User getById(Long id);
}
