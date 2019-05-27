package com.lhs.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painter;
import com.lhs.entity.PainterTag;
import com.lhs.entity.User;
import com.lhs.entity.vo.PainterVO;
import com.lhs.service.PainterService;
import com.lhs.service.PainterTagService;
import com.lhs.web.constant.ResultCode;
import com.lhs.web.form.PageForm;
import com.lhs.web.form.ResultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leonid on 2018/7/13.
 */
@RestController
@RequestMapping("/painter")
public class PainterController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(PainterController.class);

    @Autowired
    private PainterService painterService;
    @Autowired
    private PainterTagService painterTagService;

    // 编辑保存画家信息
    @PostMapping("/save")
    public Object save(Painter painter) {
        ResultForm<?> resultForm = null;
        try {
//            if (painter.getId() == null) {
//                throw new Exception("没有id，无法查询");
//            }
            painterService.insertOrUpdate(painter);
            resultForm = ResultForm.createSuccess("保存成功", painter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 通过画家id查找画家信息
    @PostMapping("/findPainterById")
    public Object find(Long id) {
        ResultForm<?> resultForm = null;
        try {
            Painter painter = painterService.selectById(id);
            resultForm = ResultForm.createSuccess("查询成功", painter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 查找画家信息
    @PostMapping("/find")
    public Object find(@RequestBody PainterVO painterVO) {
        ResultForm<Painter> resultForm = null;
        if (painterVO != null) {
            PainterVO painterDB = null;
            if (painterVO.getId() != null) {
                painterDB = painterService.findById(painterVO.getId());
            }
            if (painterDB == null && painterVO.getWxOpenid() != null) {
                painterDB = painterService.findByOpenid(painterVO.getWxOpenid());
            }
            if (painterDB != null) {
                resultForm = ResultForm.createSuccess("查询成功", painterDB);
            } else {
                resultForm = ResultForm.createError(ResultCode.NO_RESULT, "作者不存在");
            }
        } else {
            resultForm = ResultForm.createError("没有查询需要的必备条件");
        }
        return resultForm;
    }

    // 画家搜索列表
    @RequestMapping("/list")
    public Object list(PageForm<Painter> pageForm, Painter painter) {
        ResultForm<?> resultForm = null;
        Page<Painter> painterPage = painterService.listPainter(pageForm.createPage(), painter);
        if (painterPage != null && painterPage.getRecords() != null && painterPage.getRecords().size() > 0) {
            resultForm = ResultForm.createSuccess("查询成功", painterPage);
        } else {
            resultForm = ResultForm.createError(ResultCode.NO_RESULT, "没有结果");
        }
        return resultForm;
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

    @PostMapping("/allPainterTag")
    public Object getAllPainterTag() {
        ResultForm<?> resultForm = null;
        List<PainterTag> tags = painterTagService.findAll();
        if (tags != null && tags.size() > 0) {
            resultForm = ResultForm.createSuccess("查询成功", tags);
        } else {
            resultForm = ResultForm.createError(ResultCode.NO_RESULT, "未查到可用信息");
        }
        return resultForm;
    }

    @PostMapping("/findTagByPainterId")
    public Object findPainterTagByPainterId(Long painterId) {
        ResultForm<?> resultForm = null;
        List<PainterTag> tags = painterTagService.findTagByPainterId(painterId);
        if (tags != null && tags.size() > 0) {
            resultForm = ResultForm.createSuccess("查询成功", tags);
        } else {
            resultForm = ResultForm.createError(ResultCode.NO_RESULT, "未查到可用信息");
        }
        return resultForm;
    }

}
