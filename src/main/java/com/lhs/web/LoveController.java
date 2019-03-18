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
@RequestMapping("/love")
public class LoveController {

    private static Logger logger = LoggerFactory.getLogger(LoveController.class);

    //喜欢画作
    @PostMapping("/doLove")
    public Object doLove(Long paintingId) {
        return null;
    }

    //我的喜欢列表
    @PostMapping("/list")
    public Object list(PageForm<?> pageForm) {
        return null;
    }



}
