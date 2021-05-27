package com.lsl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动以后访问7002端口就欧克
@SpringBootApplication
@EnableEurekaServer //EnableEurekaServer表示服务端的启动类，欧克
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class, args);
    }
}
