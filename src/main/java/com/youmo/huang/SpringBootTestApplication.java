package com.youmo.huang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 2257
 * @date 2020/4/25 - 0:15
 */
@SpringBootApplication
@MapperScan(value = "com.youmo.huang.dao")
public class SpringBootTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class,args);
    }

}
