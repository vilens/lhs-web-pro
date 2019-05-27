package com.lhs.service;

import com.lhs.entity.PainterTag;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 画家标签 服务类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PainterTagService extends IService<PainterTag> {
    List<PainterTag> findAll();
    List<PainterTag> findTagByPainterId(Long painterId);
}
