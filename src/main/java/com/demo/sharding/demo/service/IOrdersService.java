package com.demo.sharding.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.sharding.demo.entity.Orders;
import com.demo.sharding.demo.request.SyncRequest;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
public interface IOrdersService extends IService<Orders> {

    /**
     * 同步订单
     *
     * @param request
     */
    void syncOrder(SyncRequest request);

    /**
     * 订单同步定时任务
     */
    void syncOrderTask();

}
