package com.lhs.web;

import com.lhs.annotation.NoAuth;
import com.lhs.entity.LocalSession;
import com.lhs.service.LocalSessionService;
import com.lhs.web.form.ResultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leonid on 2018/7/3.
 */
@RestController
@RequestMapping("/")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private LocalSessionService localSessionService;

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

}
