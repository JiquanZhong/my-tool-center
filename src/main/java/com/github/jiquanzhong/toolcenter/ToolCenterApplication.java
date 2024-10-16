package com.github.jiquanzhong.toolcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.github.jiquanzhong.toolcenter.*"})
public class ToolCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolCenterApplication.class, args);
    }

}
