package com.lhs.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painting;
import com.lhs.entity.vo.PaintingRecommendVO;
import com.lhs.service.PaintingService;
import com.lhs.web.form.PageForm;
import com.lhs.web.form.ResultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private PaintingService paintingService;

    @RequestMapping("/")
    public Object index() {
        return "hello";
    }

    // 主页接口
    @PostMapping("/recommendPaintings")
    public Object recommendPaintings(PageForm<PaintingRecommendVO> pageForm) {
        ResultForm<?> resultForm = null;
        try {
            if (pageForm == null) {
                pageForm = new PageForm<>(2, 1);
            }
            Page<PaintingRecommendVO> page = paintingService.pageRecommendPaintings(pageForm.createPage());
            resultForm = ResultForm.createSuccess("查询成功", page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }
}
