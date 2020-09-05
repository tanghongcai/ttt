package com.newer.blog.web.control;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Spring Boot 应用的标识
@SpringBootApplication
@ComponentScan("com.newer.blog")//必须使用ComponentScan扫描包！
//mapper 接口类扫描包配置
@MapperScan("com.newer.blog.data.dao")
//启注解事务管理
@EnableTransactionManagement
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
