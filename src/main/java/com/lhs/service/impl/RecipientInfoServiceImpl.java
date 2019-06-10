package com.lhs.service.impl;

import com.lhs.entity.RecipientInfo;
import com.lhs.mapper.RecipientInfoMapper;
import com.lhs.service.RecipientInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 收货信息表 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class RecipientInfoServiceImpl extends ServiceImpl<RecipientInfoMapper, RecipientInfo> implements RecipientInfoService {
    public List<RecipientInfo> findByOpenid(String wxOpenid) {
        return baseMapper.findByOpenid(wxOpenid);
    }
}
