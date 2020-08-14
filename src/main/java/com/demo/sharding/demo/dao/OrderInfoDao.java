package com.demo.sharding.demo.dao;



import com.demo.sharding.demo.entity.OrderInfo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-15
 */

public interface OrderInfoDao {

    List<OrderInfo> List(String startDate, String endDate, int num, int pageSize);


    /**
     * 统计数量
     *
     * @param startDate
     * @param endDate
     * @return
     */
    Integer count(String startDate, String endDate);

    /**
     * 日期范围内的订单
     *
     * @param startDate
     * @param endDate
     */
    void getAllOrder(String startDate, String endDate);

}
