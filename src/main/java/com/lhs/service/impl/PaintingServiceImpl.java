package com.lhs.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painting;
import com.lhs.entity.vo.PaintingRecommendVO;
import com.lhs.mapper.PaintingMapper;
import com.lhs.service.PaintingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<PaintingRecommendVO> pageRecommendPaintings(Long userId, Page page) throws Exception {
        // 待实现
        return null;
    }


}
