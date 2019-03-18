package com.lhs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painting;
import com.baomidou.mybatisplus.service.IService;
import com.lhs.entity.vo.PaintingRecommendVO;

/**
 * <p>
 * 画作表 服务类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PaintingService extends IService<Painting> {

    /**
     * 分页显示推荐作品
     * @param userId
     * @param page
     * @return
     * @throws Exception
     */
    Page<PaintingRecommendVO> pageRecommendPaintings(Long userId, Page page) throws Exception;


}
