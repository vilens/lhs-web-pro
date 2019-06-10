package com.lhs.mapper;

import com.lhs.entity.RecipientInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 收货信息表 Mapper 接口
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface RecipientInfoMapper extends BaseMapper<RecipientInfo> {
    List<RecipientInfo> findByUserid(String wxOpenid);
    List<RecipientInfo> findByOpenid(String wxOpenid);
}
