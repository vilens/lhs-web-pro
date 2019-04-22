package com.lhs.web;

import com.alibaba.fastjson.JSONObject;
import com.lhs.annotation.NoAuth;
import com.lhs.entity.LocalSession;
import com.lhs.entity.User;
import com.lhs.service.LocalSessionService;
import com.lhs.service.UserService;
import com.lhs.util.StringUtils;
import com.lhs.web.constant.ResultCode;
import com.lhs.web.form.ResultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leonid on 2018/7/3.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private LocalSessionService localSessionService;
    @Autowired
    private UserService userService;

    @NoAuth
    @RequestMapping("/login")
    public Object login(String username, String password) {
        ResultForm<LocalSession> resultForm = null;
        try {
            LocalSession session = localSessionService.login(username, password, 30000L);
            resultForm = ResultForm.createSuccess("登录成功", session);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError("登录失败，请稍后重试");
        }
        return resultForm;
    }

    @RequestMapping("/index")
    public Object index() {
        return "hello";
    }

    @RequestMapping("/findUser")
    public Object findUser(@RequestBody(required = false) JSONObject jsonRequestBody) {
        ResultForm<User> resultForm = null;
        User user = JSONObject.parseObject(jsonRequestBody.toJSONString(), User.class);
        try {
            if (user != null && StringUtils.notEmpty(user.getWxOpenid())) {
                user = userService.findUser(user);
            }
            if (user != null) {
                resultForm = ResultForm.createSuccess("查询成功", user);
            } else {
                resultForm = ResultForm.createError(ResultCode.NO_USER, "用户不存在");
            }
        } catch (Exception e) {
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    @RequestMapping("/saveUser")
    public Object addUser(@RequestBody(required = false) JSONObject jsonRequestBody) {
        ResultForm<?> resultForm = null;
        User user = JSONObject.parseObject(jsonRequestBody.toJSONString(), User.class);
        int reuslt = 0;
        try {
            if (user != null && StringUtils.notEmpty(user.getWxOpenid())) {
                User userDB = userService.findUser(user);
                if (userDB != null) {
                    if (userDB.getWxOpenid().equals(user.getWxOpenid())) {
                        userService.updateUser(user);
                        userDB = userService.findUser(user);
                        resultForm = ResultForm.createSuccess("保存成功", userDB);
                    } else {
                        resultForm = ResultForm.createError("用户openid不匹配");
                    }
                } else {
                    if (user != null && StringUtils.notEmpty(user.getWxOpenid())) {
                        userService.createUser(user);
                        userDB = userService.findUser(user);
                    }
                    if (userDB != null) {
                        resultForm = ResultForm.createSuccess("添加成功", userDB);
                    } else {
                        resultForm = ResultForm.createError("用户不存在");
                    }
                }
            } else {
                resultForm = ResultForm.createError("用户或者openid为空");
            }
        } catch (Exception e) {
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

}
