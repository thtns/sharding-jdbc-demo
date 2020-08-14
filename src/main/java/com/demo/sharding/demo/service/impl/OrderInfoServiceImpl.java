package com.demo.sharding.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.demo.sharding.demo.entity.OrderInfo;
import com.demo.sharding.demo.mapper.OrderInfoMapper;
import com.demo.sharding.demo.request.SyncRequest;
import com.demo.sharding.demo.service.IOrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
@Service
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Override
    public void batchSave(List<OrderInfo> orderInfos) {

        for (OrderInfo orderInfo : orderInfos) {

            try {
                orderInfo.setSync(false);
                baseMapper.insert(orderInfo);
            } catch (DuplicateKeyException e) {
                log.error("订单重复插入，订单ID是{}", orderInfo.getOrderNo());
            }

        }
    }

    @Override
    public List<OrderInfo> orderList(SyncRequest request) {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(OrderInfo.SYNC, false);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public int count(SyncRequest request) {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(OrderInfo.SYNC, false);
        queryWrapper.ge(OrderInfo.CREATE_TIME, request.getStartDate());
        queryWrapper.lt(OrderInfo.CREATE_TIME, request.getEndDate());
        return baseMapper.selectCount(queryWrapper);
    }

    @Override
    public List<OrderInfo> listBySync() {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(OrderInfo.SYNC, false);
        queryWrapper.last("limit 5000");
        return baseMapper.selectList(queryWrapper);
    }
}
