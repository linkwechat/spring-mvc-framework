package com.linkwechat.spring.mvc.framework.service;

import com.linkwechat.spring.mvc.framework.model.User;

/**
 * 用户服务层接口
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
public interface UserService {
    /**
     * 获取用户信息
     *
     * @param userId
     *            用户id
     * @return User
     */
    User getUserInfo(Long userId);
}
