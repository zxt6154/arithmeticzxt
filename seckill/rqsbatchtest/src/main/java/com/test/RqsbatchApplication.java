package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.test.mapper")
public class RqsbatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(RqsbatchApplication.class,args);
    }
}
