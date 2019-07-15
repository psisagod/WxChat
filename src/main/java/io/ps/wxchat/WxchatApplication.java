package io.ps.wxchat;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("io.ps.wxchat.dao")
@SpringBootApplication
@EnableFeignClients
public class WxchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxchatApplication.class, args);
    }

}
