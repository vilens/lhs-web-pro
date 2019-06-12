package com.lhs.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painting;
import com.lhs.entity.PaintingImages;
import com.lhs.entity.vo.PaintingVO;
import com.lhs.service.LocalSessionService;
import com.lhs.service.PaintingImagesService;
import com.lhs.service.PaintingService;
import com.lhs.util.StringUtils;
import com.lhs.web.form.PageForm;
import com.lhs.web.form.ResultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

/**
 * Created by Leonid on 2018/7/13.
 */
@RestController
@RequestMapping("/painting")
public class PaintingController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(PaintingController.class);

    @Autowired
    private PaintingService paintingService;
    @Autowired
    private PaintingImagesService paintingImagesService;
    @Autowired
    private LocalSessionService localSessionService;

    // 保存作品信息
    @PostMapping("/save")
    public Object save(@RequestBody Painting painting) {
        ResultForm<?> resultForm = null;
        try {
            paintingService.insertOrUpdate(painting);
            resultForm = ResultForm.createSuccess("保存成功", painting);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 保存作品信息
    @PostMapping("/saveImage")
    public Object saveImage(@RequestBody PaintingImages paintingImages) {
        ResultForm<?> resultForm = null;
        try {
            paintingImagesService.insertOrUpdate(paintingImages);
            resultForm = ResultForm.createSuccess("保存成功", paintingImages);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    @RequestMapping("/myPaintings")
    public Object myPaintings(PageForm<Painting> pageForm, String wxOpenid) {
        ResultForm<?> resultForm = null;
        try {
            if (StringUtils.notEmpty(wxOpenid)) {
                Page<Painting> paintingPage = paintingService.pageByOpenid(pageForm.createPage(), wxOpenid);
                resultForm = ResultForm.createSuccess("查询成功", paintingPage);
            } else {
                resultForm = ResultForm.createError("没有openid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    @RequestMapping("/painterPaintings")
    public Object painterPaintings(PageForm<Painting> pageForm, String painterId) {
        ResultForm<?> resultForm = null;
        try {
            if (StringUtils.notEmpty(painterId)) {
                Page<Painting> paintingPage = paintingService.pageByPainterId(pageForm.createPage(), painterId);
                resultForm = ResultForm.createSuccess("查询成功", paintingPage);
            } else {
                resultForm = ResultForm.createError("没有openid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    @RequestMapping("/findAll")
    public Object findAll(PageForm<Painting> pageForm) {
        ResultForm<?> resultForm = null;
        System.out.println(pageForm.getCurrentPage());
        try {
            Page<Painting> paintingPage = paintingService.selectPage(pageForm.createPage());
            resultForm = ResultForm.createSuccess("查询成功", paintingPage);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 上传作品补充
    @PostMapping("/uploadPaintingImage")
    public Object uploadPaintingImage(@RequestParam("file") MultipartFile file) {
        ResultForm<?> resultForm = null;
        try {
            String imagePath = paintingImagesService.uploadImage(file);
            resultForm = ResultForm.createSuccess("上传成功", imagePath);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 主页接口
    @PostMapping("/recommendPaintings")
    public Object recommendPaintings(PageForm<Painting> pageForm) {
        ResultForm<?> resultForm = null;
        try {
            Page<Painting> paintingPage = paintingService.selectPage(pageForm.createPage());
            resultForm = ResultForm.createSuccess("查询成功", paintingPage);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 详情页接口
    @PostMapping("/paintingDetail")
    public Object paintingDetail(Long paintingId) {
        ResultForm<?> resultForm = null;
        try {
            if (paintingId != null) {
                PaintingVO paintingVO = paintingService.selectOneById(paintingId);
                resultForm = ResultForm.createSuccess("查询成功", paintingVO);
            } else {
                resultForm = ResultForm.createError("paintainId");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    // 故事页接口
    @PostMapping("/paintingStory")
    public Object paintingStory(Long paintingId) {
        return null;
    }

}
