package com.demo.sharding.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.sharding.demo.entity.OrderInfo;
import com.demo.sharding.demo.request.SyncRequest;


import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    void batchSave(List<OrderInfo> orderInfos);

    /**
     * t
     *
     * @param request
     */
    List<OrderInfo> orderList(SyncRequest request);

    /**
     * 统计数量
     *
     * @param request
     * @return
     */
    int count(SyncRequest request);

    /**
     * @return
     */
    List<OrderInfo> listBySync();
}
