package com.demo.sharding.demo.config;

import com.demo.sharding.demo.properties.OracleDataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class OracleDataSourceConfig {


    private OracleDataSourceProperties oracleDataSourceProperties;

    @Bean("oracle")
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(oracleDataSourceProperties.getUsername());
        hikariDataSource.setPassword(oracleDataSourceProperties.getPassword());
        hikariDataSource.setDriverClassName(oracleDataSourceProperties.getDriverClassName());
        hikariDataSource.setJdbcUrl(oracleDataSourceProperties.getUrl());
        return hikariDataSource;
    }

    ;


    @Bean()
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }


    @Autowired
    public void setOracleDataSourceProperties(OracleDataSourceProperties oracleDataSourceProperties) {
        this.oracleDataSourceProperties = oracleDataSourceProperties;
    }


}
