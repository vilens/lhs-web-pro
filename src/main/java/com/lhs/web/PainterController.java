package com.lhs.web;

import com.lhs.entity.Painter;
import com.lhs.service.PainterService;
import com.lhs.web.form.PageForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leonid on 2018/7/13.
 */
@RestController
@RequestMapping("/painter")
public class PainterController {

    private static Logger logger = LoggerFactory.getLogger(PainterController.class);

    @Autowired
    private PainterService painterService;

    // 编辑保存画家信息
    @PostMapping("/save")
    public Object save(Painter painter) {
        return null;
    }

    // 画家搜索列表
    @PostMapping("/list")
    public Object list(PageForm<?> pageForm, String painterName) {
        return null;
    }

    // 画家详情信息
    @PostMapping("/painterDetail")
    public Object painterDetail(Long painterId) {
        return null;
    }

    // 画家画作list
    @PostMapping("/painterPaintings")
    public Object painterPaintings(Long painterId) {
        return null;
    }

}
