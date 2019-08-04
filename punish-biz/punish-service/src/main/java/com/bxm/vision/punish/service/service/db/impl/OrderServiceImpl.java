package com.bxm.vision.punish.service.service.db.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bxm.vision.punish.dal.mapper.OrderMapper;
import com.bxm.vision.punish.model.dao.Order;
import com.bxm.vision.punish.service.service.db.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author kk.xie
 * @since 2019-08-03
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
