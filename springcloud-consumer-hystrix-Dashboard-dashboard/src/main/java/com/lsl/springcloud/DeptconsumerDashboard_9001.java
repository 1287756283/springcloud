package com.lsl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启监控界面
public class DeptconsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptconsumerDashboard_9001.class,args);
    }

}
