package com.lhs.mapper;

import com.lhs.entity.Painter;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 画家表 Mapper 接口
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PainterMapper extends BaseMapper<Painter> {

    public Painter getById(Long id);

}
