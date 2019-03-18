package com.lhs.service.impl;

import com.lhs.entity.Painter;
import com.lhs.mapper.PainterMapper;
import com.lhs.service.PainterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * <p>
 * 画家表 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class PainterServiceImpl extends ServiceImpl<PainterMapper, Painter> implements PainterService {
    @PostConstruct
    public void init () {
        Object o = this.baseMapper.getById(1L);
        System.out.println(o);
    }
}
