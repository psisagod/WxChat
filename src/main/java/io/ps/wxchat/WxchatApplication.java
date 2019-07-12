package io.ps.wxchat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("io.ps.wxchat.dao")
@SpringBootApplication
public class WxchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxchatApplication.class, args);
    }

}
