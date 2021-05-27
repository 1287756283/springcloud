package com.lsl.springcloud;

import com.lsl.myRule.AliezRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//Ribbon跟Eureka整合以后，客户端可以直接调用，无需关心ip地址和端口号
@SpringBootApplication
@EnableEurekaClient
//在微服务启动时就可以加载自定义负载均衡的配置
@RibbonClient(name = "springcloud-provider-dept",configuration = AliezRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
