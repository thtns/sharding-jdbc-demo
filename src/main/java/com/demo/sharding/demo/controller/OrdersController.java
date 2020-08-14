package com.demo.sharding.demo.controller;


import com.demo.sharding.demo.request.SyncRequest;
import com.demo.sharding.demo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private IOrdersService ordersService;


    @PostMapping("start")
    public void start(@RequestBody SyncRequest request) {
        ordersService.syncOrder(request);
    }

    @Autowired
    public void setOrdersService(IOrdersService ordersService) {
        this.ordersService = ordersService;
    }
}
