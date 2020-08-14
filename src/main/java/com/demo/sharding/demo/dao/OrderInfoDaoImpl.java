package com.demo.sharding.demo.dao;


import com.demo.sharding.demo.entity.OrderInfo;
import com.demo.sharding.demo.service.IOrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
@Slf4j
public class OrderInfoDaoImpl implements OrderInfoDao {

    private JdbcTemplate jdbcTemplate;

    private IOrderInfoService orderInfoService;

    @Override
    public List<OrderInfo> List(String startDate, String endDate, int num, int pageSize) {
        String start = String.format("'%s'", startDate);
        String end = String.format("'%s'", endDate);
        String sql = "select * from (select * ORDER_INFO where ORDER_INFO.rowNo >=" + num + " and ORDER_INFO.rowNo <=" + pageSize + "";
        BeanPropertyRowMapper<OrderInfo> orderInfoBeanPropertyRowMapper = BeanPropertyRowMapper.newInstance(OrderInfo.class);
        return jdbcTemplate.query(sql, orderInfoBeanPropertyRowMapper);
    }


    @Override
    public Integer count(String startDate, String endDate) {
        String start = String.format("'%s'", startDate);
        String end = String.format("'%s'", endDate);
        String sql = "select  count(*)  from ORDER_INFO  where DELETED='0' and CREATE_TIME >= to_date(" + start + ",'yyyy-mm-dd') and CREATE_TIME <to_date(" + end + ",'yyyy-mm-dd')+1";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void getAllOrder(String startDate, String endDate) {
        int count = this.count(startDate, endDate);
        log.info("一共有{}条数据", count);
        int pageSize = 10000;
        int number = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        log.info("一共要循环{}次", number);
        for (int i = 0; i < number; i++) {
            LocalDateTime now = LocalDateTime.now();
            List<OrderInfo> orderInfos;
            if (i == 0) {
                orderInfos = this.List(startDate, endDate, i + 1, pageSize);
            } else {
                orderInfos = this.List(startDate, endDate, 1 + (pageSize * i), pageSize * (i + 1));
            }
            orderInfoService.batchSave(orderInfos);
            log.info("{}条数据共花费：{} 秒", orderInfos.size(), now.until(LocalDateTime.now(), ChronoUnit.SECONDS));
            orderInfos.clear();
        }

    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setOrderInfoService(IOrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }
}
