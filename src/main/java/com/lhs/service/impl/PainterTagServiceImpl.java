package com.lhs.service.impl;

import com.lhs.entity.PainterTag;
import com.lhs.mapper.PainterTagMapper;
import com.lhs.service.PainterTagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 画家标签 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class PainterTagServiceImpl extends ServiceImpl<PainterTagMapper, PainterTag> implements PainterTagService {

    @Override
    public List<PainterTag> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public List<PainterTag> findTagByPainterId(Long painterId) {
        return baseMapper.findTagByPainterId(painterId);
    }
}
