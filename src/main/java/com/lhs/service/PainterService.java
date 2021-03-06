package com.lhs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painter;
import com.baomidou.mybatisplus.service.IService;
import com.lhs.entity.vo.PainterVO;

/**
 * <p>
 * 画家表 服务类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PainterService extends IService<Painter> {
    PainterVO findById(Long id);
    PainterVO findDetailById(Long id);
    PainterVO findByUserId(Long id);
    PainterVO findByOpenid(String openid);
    PainterVO findOne(PainterVO painter);
    PainterVO findAll(PainterVO painter);
    Page<PainterVO> listPainter(Page<PainterVO> page, PainterVO painter);
}
