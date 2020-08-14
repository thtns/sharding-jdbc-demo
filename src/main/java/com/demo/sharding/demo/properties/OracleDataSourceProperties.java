package com.demo.sharding.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "datasource.oracle")
@Component
@Data
public class OracleDataSourceProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
