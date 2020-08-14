package com.demo.sharding.demo.controller;


import com.demo.sharding.demo.dao.OrderInfoDao;
import com.demo.sharding.demo.request.SyncRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

    private OrderInfoDao orderInfoDao;

    @PostMapping("start")
    public void start(@RequestBody SyncRequest request) {
        orderInfoDao.getAllOrder(request.getStartDate(), request.getEndDate());
    }

    @PostMapping("count")
    public Integer count(@RequestBody SyncRequest request) {
        return orderInfoDao.count(request.getStartDate(), request.getEndDate());
    }

    @Autowired
    public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
        this.orderInfoDao = orderInfoDao;
    }
}
