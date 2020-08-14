package com.demo.sharding.demo.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OrdersShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {

        List<String> shardingResults = new ArrayList<>();

        String logicTableName = shardingValue.getLogicTableName();
        Map<String, Collection> valuesMap = shardingValue.getColumnNameAndShardingValuesMap();

        ConvertBean convertBean = new ConvertBean();

        valuesMap.forEach((k, v) -> {
            String value = v.stream().findFirst().get().toString();
            if (k.equals("order_status")) {
                convertBean.setOrderStatus(value);
            }
            if (k.equals("create_time")) {
                convertBean.setCreateTime(LocalDateTime.parse(value));
            }
            if (k.equals("product_name")) {
                convertBean.setProductName(value);
            }
            if (k.equals("buyer_name")) {
                convertBean.setBuyerName(value);
            }
            if (k.equals("link_name")) {
                convertBean.setLinkName(value);
            }
        });

        if (StringUtils.hasText(convertBean.getProductName()) && (convertBean.getProductName().contains("惠民") || convertBean.getProductName().contains("测试"))) {
            shardingResults.add(logicTableName + "_" + "free");
        } else if (StringUtils.hasText(convertBean.getBuyerName()) && (convertBean.getBuyerName().contains("测试"))) {
            shardingResults.add(logicTableName + "_" + "free");
        } else if (StringUtils.hasText(convertBean.getLinkName()) && (convertBean.getLinkName().contains("侯越") || convertBean.getLinkName().contains("陈思聪") || convertBean.getLinkName().contains("测试"))) {
            shardingResults.add(logicTableName + "_" + "free");
        } else {
            if (convertBean.getOrderStatus().equals("3") || convertBean.getOrderStatus().equals("4") || convertBean.getOrderStatus().equals("5") || convertBean.getOrderStatus().equals("6") || convertBean.getOrderStatus().equals("7") || convertBean.getOrderStatus().equals("8")) {
                LocalDateTime create_time = convertBean.getCreateTime();
                int year = create_time.getYear();
                LocalDateTime parse = LocalDateTime.of(2020, 1, 1, 0, 0);

                if (create_time.isBefore(parse)) {
                    shardingResults.add(logicTableName + "_" + 2017 + "_" + 2019);
                } else {
                    shardingResults.add(logicTableName + "_" + year);
                }
            } else {
                shardingResults.add(logicTableName + "_" + "error");
            }
        }
        return shardingResults;
    }

}

