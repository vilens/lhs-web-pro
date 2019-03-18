package com.lhs.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.lhs.entity.Painting;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lhs.entity.vo.PaintingRecommendVO;

import java.util.List;

/**
 * <p>
 * 画作表 Mapper 接口
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PaintingMapper extends BaseMapper<Painting> {

    List<PaintingRecommendVO> pagePaintingRecommendVO(Pagination pagination, Long userId);


}
