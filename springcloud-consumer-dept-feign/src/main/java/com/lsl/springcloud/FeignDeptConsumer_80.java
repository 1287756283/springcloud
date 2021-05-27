package com.lsl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


//Ribbon跟Eureka整合以后，客户端可以直接调用，无需关心ip地址和端口号
@SpringBootApplication(scanBasePackages = "com.lsl.springcloud")
@EnableEurekaClient
@EnableFeignClients( basePackages = {"com.lsl.springcloud"})
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }
}
