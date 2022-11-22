package com.hope.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hope.quartz.mapper")
@EnableScheduling //开启定时任务的注解
public class SpringBootQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuartzApplication.class, args);
    }

}
