package com.lhs.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painter;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lhs.entity.vo.PainterVO;

import java.util.List;

/**
 * <p>
 * 画家表 Mapper 接口
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PainterMapper extends BaseMapper<Painter> {

    public PainterVO getById(Long id);
    public PainterVO getByUserId(Long id);
    public PainterVO getByOpenid(String openid);
    public List<Painter> listPainter(Page<Painter> page, Painter painter);

}
