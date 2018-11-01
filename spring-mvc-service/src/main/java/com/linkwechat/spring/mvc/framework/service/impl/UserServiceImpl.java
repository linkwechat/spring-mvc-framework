package com.linkwechat.spring.mvc.framework.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.linkwechat.spring.mvc.framework.dao.UserDao;
import com.linkwechat.spring.mvc.framework.model.User;
import com.linkwechat.spring.mvc.framework.service.UserService;

/**
 * 用户服务层实现
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    protected UserDao userDao;

    @Override
    public User getUserInfo(Long userId) {
        User user = userDao.getById(userId);
        logger.info("User info: id=" + userId + ", name=" + user.getName() + ", tel=" + user.getTel());
        return user;
    }
}
