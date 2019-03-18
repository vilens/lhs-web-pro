package com.lhs.service.impl;

import com.lhs.entity.Order;
import com.lhs.mapper.OrderMapper;
import com.lhs.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
