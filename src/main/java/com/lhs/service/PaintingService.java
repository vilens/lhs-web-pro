package com.lhs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.lhs.entity.Painting;
import com.baomidou.mybatisplus.service.IService;
import com.lhs.entity.vo.PaintingRecommendVO;
import com.lhs.entity.vo.PaintingVO;

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
     *
     * @param page
     * @return
     * @throws Exception
     */
    Page<PaintingRecommendVO> pageRecommendPaintings(Page page) throws Exception;


    /**
     * 分页查找我的作品
     *
     * @param page
     * @return
     * @throws Exception
     */
    Page<Painting> pageByOpenid(Page<Painting> page, String wxOpenid) throws Exception;
    Page<Painting> pageByPainterId(Page<Painting> page, String painterId) throws Exception;

    PaintingVO selectOneById(Long paintingId) throws Exception;
}
