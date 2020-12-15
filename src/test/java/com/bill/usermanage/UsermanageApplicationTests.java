package com.bill.usermanage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class UsermanageApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        //查看默认数据源 :com.zaxxer.hikari.HikariDataSource
        //加了spring.dataource.type：指定druid  -》class com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass());
    }

}
