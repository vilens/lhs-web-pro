package com.lhs.service;

import com.lhs.entity.RecipientInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 收货信息表 服务类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface RecipientInfoService extends IService<RecipientInfo> {
    public List<RecipientInfo> findByOpenid(String wxOpenid);
}
