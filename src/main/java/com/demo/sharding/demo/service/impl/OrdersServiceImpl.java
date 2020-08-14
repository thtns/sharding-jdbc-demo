package com.demo.sharding.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.sharding.demo.entity.OrderInfo;
import com.demo.sharding.demo.entity.Orders;
import com.demo.sharding.demo.mapper.OrdersMapper;
import com.demo.sharding.demo.request.SyncRequest;
import com.demo.sharding.demo.service.IOrderInfoService;
import com.demo.sharding.demo.service.IOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
@Service
@Slf4j
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {


    private IOrderInfoService orderInfoService;


    @Override
    public void syncOrder(SyncRequest request) {
        int count = orderInfoService.count(request);
        log.info("一共有{}条数据", count);
        int pageSize = 1000;
        int number = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        log.info("一共要循环{}次", number);
        for (int i = 0; i < number; i++) {
            LocalDateTime now = LocalDateTime.now();
            Page<OrderInfo> ordersPage = new Page<>();
            ordersPage.setCurrent(i + 1);
            ordersPage.setSize(pageSize);
            QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(OrderInfo.SYNC, false);
            Page<OrderInfo> page = orderInfoService.page(ordersPage, queryWrapper);
            List<OrderInfo> records = page.getRecords();
            List<Orders> collect = records.stream().map(convert()).collect(Collectors.toList());
            this.saveBatch(collect);
            records.forEach(orderInfo -> orderInfo.setSync(true));
            orderInfoService.updateBatchById(records);
            log.info("{}条数据共花费：{} 秒", records.size(), now.until(LocalDateTime.now(), ChronoUnit.SECONDS));
        }
    }

    @Override
    public void syncOrderTask() {
        log.info("定时任务开始执行");
        LocalDateTime now = LocalDateTime.now();
        List<OrderInfo> orderInfos = orderInfoService.listBySync();
        log.info("一共有{}条数据", orderInfos.size());
        if (CollUtil.isNotEmpty(orderInfos)) {
            List<Orders> collect = orderInfos.stream().map(convert()).collect(Collectors.toList());
            this.saveBatch(collect);
            orderInfos.forEach(orderInfo -> orderInfo.setSync(true));
            orderInfoService.updateBatchById(orderInfos);
            log.info("{}条数据共花费：{} 秒", orderInfos.size(), now.until(LocalDateTime.now(), ChronoUnit.SECONDS));
        }
    }

    public Function<OrderInfo, Orders> convert() {
        return orderInfo -> BeanUtil.toBean(orderInfo, Orders.class);
    }



    @Autowired
    public void setOrderInfoService(IOrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

}
