package com.linkwechat.spring.mvc.framework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linkwechat.commons.util.JsonUtils;
import com.linkwechat.spring.mvc.framework.controller.aop.WebOpt;
import com.linkwechat.spring.mvc.framework.exception.ReturnType;
import com.linkwechat.spring.mvc.framework.model.User;
import com.linkwechat.spring.mvc.framework.service.UserService;
import com.linkwechat.spring.mvc.framework.vo.BizResponse;

/**
 * 用户接口服务
 * 
 * @author linkwechat linkwechat@foxmail.com
 * @version 1.0
 */
@Controller
@RequestMapping("api/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 获取用户信息
     *
     * @param userId
     *            用户id
     * @return String 用户信息
     */
    @WebOpt
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String getUserInfo(HttpServletRequest request, Long userId) {
        User user = null;
        try {
            user = userService.getUserInfo(userId);
        } catch (Exception e) {
            logger.error("获取用户信息失败: id=" + userId, e);
            BizResponse bizResponse = new BizResponse(e);
            return bizResponse.toString();
        }

        BizResponse bizResponse = new BizResponse(ReturnType.SUCCESS, JsonUtils.getStandardJsonString(user));
        logger.info("获取用户信息成功: " + bizResponse);

        return bizResponse.toString();
    }
}
