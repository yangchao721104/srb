package com.yang.srb.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.yang.srb", "com.yang.common"})
@EnableFeignClients
public class ServiceSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSmsApplication.class, args);
    }
}
