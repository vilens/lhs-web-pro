package com.lhs.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painter;
import com.lhs.entity.vo.PainterVO;
import com.lhs.mapper.PainterMapper;
import com.lhs.service.PainterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @Override
    public PainterVO findById(Long id) {
        return baseMapper.getById(id);
    }

    @Override
    public PainterVO findByUserId(Long id) {
        return baseMapper.getByUserId(id);
    }

    @Override
    public PainterVO findByOpenid(String openid) {
        return baseMapper.getByOpenid(openid);
    }

    @Override
    public PainterVO findOne(PainterVO painterVO) {
        //TODO
        return null;
    }

    @Override
    public PainterVO findAll(PainterVO painter) {
        return null;
    }

    @Override
    public Page<Painter> listPainter(Page<Painter> page,Painter painter) {
        if (page == null) {
            throw new IllegalArgumentException();
        }
        List<Painter> painterList = this.baseMapper.listPainter(page, painter);
        page.setRecords(painterList);
        return page;
    }
}
