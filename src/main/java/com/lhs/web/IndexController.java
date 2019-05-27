package com.lhs.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexController {

    @RequestMapping("/")
    public Object index() {
        return "hello";
    }
}
