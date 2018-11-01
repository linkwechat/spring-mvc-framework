package com.linkwechat.spring.mvc.framework.dao.impl;

import org.springframework.stereotype.Component;

import com.linkwechat.spring.mvc.framework.dao.UserDao;
import com.linkwechat.spring.mvc.framework.model.User;

/**
 * 用户数据层实现
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public User getById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("demo");
        user.setTel("13888888888");
        return user;
    }
}
