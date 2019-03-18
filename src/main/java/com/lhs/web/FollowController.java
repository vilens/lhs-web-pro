package com.lhs.web;

import com.lhs.web.form.PageForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leonid on 2018/7/13.
 */
@RestController
@RequestMapping("/follow")
public class FollowController {

    private static Logger logger = LoggerFactory.getLogger(FollowController.class);

    // 关注
    @PostMapping("/doFollow")
    public Object doFollow(Long painterId) {
        return null;
    }

    // 我的关注作者
    @PostMapping("/list")
    public Object list(PageForm<?> pageForm) {
        return null;
    }

}
