package com.lhs.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lhs.service.ClassifyService;
import com.lhs.web.form.ResultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leonid on 2018/7/3.
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    private static Logger logger = LoggerFactory.getLogger(ClassifyController.class);

    @Autowired
    private ClassifyService classifyService;

    /**
     * 获取全部分类
     * @return
     */
    @PostMapping("/getAll")
    public Object getAll() {
        ResultForm<?> resultForm = null;
        try {
            List list = classifyService.selectList(new EntityWrapper<>());
            resultForm = ResultForm.createSuccess("查询成功", list);
        } catch (Exception e) {
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

}
