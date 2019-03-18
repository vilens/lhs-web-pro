package com.lhs.web;

import com.lhs.service.LocalSessionService;
import com.lhs.service.PaintingService;
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
@RequestMapping("/painting")
public class PaintingController {

    private static Logger logger = LoggerFactory.getLogger(PaintingController.class);

    @Autowired
    private PaintingService paintingService;
    @Autowired
    private LocalSessionService localSessionService;

    // 主页接口
    @PostMapping("/recommendPaintings")
    public Object recommendPaintings(PageForm<?> pageForm) {
        // userId
        return null;
    }

    // 详情页接口
    @PostMapping("/paintingDetail")
    public Object paintingDetail(Long paintingId) {
        return null;
    }

    // 故事页接口
    @PostMapping("/paintingStory")
    public Object paintingStory(Long paintingId) {
        return null;
    }

}
