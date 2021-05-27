package com.lsl.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliezRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();   //自定义为每个服务循环5次
    }

}
