package com.demo.gradledemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.demo.gradledemo.mapper")
@SpringBootApplication
public class GradledemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradledemoApplication.class, args);
    }
}
