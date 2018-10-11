package com.zspace.message.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({
        "com.zspace.message"
})
@MapperScan({
        "com.zspace.message.dao"
})
public class ReliableMessageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReliableMessageServerApplication.class, args);
    }
}
