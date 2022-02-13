package com.tradoon.mallmbg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tradoon.mallmbg.dao")
public class MallMbgApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMbgApplication.class, args);
    }

}
