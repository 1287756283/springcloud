package com.lsl.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //Configuration --相当于applicaiontcontext.xml
    //配置负载均衡实现RestTemplate
    //很重要的接口->>>iRule
    /*
    * AbstractLoadBalancerRule  :会先过滤掉，跳闸(崩溃)，访问故障的服务，对剩下的服务进行轮询
    * RoundRobinRule            :轮询策略
    * RandomRule                :随机策略
    * WeightedResponseTimeRule  :权重策略
    * RetryRule                 :重试策略，如果服务获取失败，则会在指定时间内进行重试
    * */
    @Bean
    @LoadBalanced //ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
