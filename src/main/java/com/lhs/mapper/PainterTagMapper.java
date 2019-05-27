package com.lhs.mapper;

import com.lhs.entity.PainterTag;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 画家标签 Mapper 接口
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PainterTagMapper extends BaseMapper<PainterTag> {
    List<PainterTag> findAll();
    List<PainterTag> findTagByPainterId(Long painterId);
}
