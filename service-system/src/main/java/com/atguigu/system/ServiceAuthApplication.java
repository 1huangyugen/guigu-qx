package com.atguigu.system;
//8

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shkstart
 * @date 2023/4/3-13:55
 */
@SpringBootApplication
@MapperScan("com.atguigu.system.mapper")//mapper扫描
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
