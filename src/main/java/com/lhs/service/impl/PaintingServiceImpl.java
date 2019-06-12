package com.lhs.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painting;
import com.lhs.entity.PaintingImages;
import com.lhs.entity.vo.PaintingRecommendVO;
import com.lhs.entity.vo.PaintingVO;
import com.lhs.mapper.PaintingMapper;
import com.lhs.service.PaintingImagesService;
import com.lhs.service.PaintingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 画作表 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class PaintingServiceImpl extends ServiceImpl<PaintingMapper, Painting> implements PaintingService {

    @Autowired
    PaintingImagesService paintingImagesService;

    @Override
    public Page<PaintingRecommendVO> pageRecommendPaintings(Page page) throws Exception {
        // 待实现
        return null;
    }

    @Override
    public Page<Painting> pageByOpenid(Page<Painting> page, String wxOpenid) throws Exception {
        if (page == null) {
            throw new IllegalArgumentException();
        }
        List<Painting> painting = this.baseMapper.pageByOpenid(page, wxOpenid);
        page.setRecords(painting);
        return page;
    }

    @Override
    public Page<Painting> pageByPainterId(Page<Painting> page, String painterId) throws Exception {
        if (page == null) {
            throw new IllegalArgumentException();
        }
        List<Painting> painting = this.baseMapper.pageByPainterId(page, painterId);
        page.setRecords(painting);
        return page;
    }

    @Override
    public PaintingVO selectOneById(Long paintingId) throws Exception {
        if (paintingId == null) {
            throw new IllegalArgumentException();
        }
        PaintingVO result = baseMapper.selectOneById(paintingId);
        result.setImages(paintingImagesService.selectList(paintingId));
        return result;
    }


}
