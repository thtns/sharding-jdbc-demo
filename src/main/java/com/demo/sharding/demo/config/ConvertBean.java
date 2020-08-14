package com.demo.sharding.demo.config;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConvertBean {
    private String orderStatus;
    private LocalDateTime createTime;
    private String productName;
    private String buyerName;
    private String linkName;
}
