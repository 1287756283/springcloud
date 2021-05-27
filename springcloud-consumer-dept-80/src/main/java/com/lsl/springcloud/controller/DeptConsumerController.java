package com.lsl.springcloud.controller;

import com.lsl.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //理解：消费者，不应该有<dependency>
    //支持RestFul风格
    //RestTemplate ....供我们直接调用，注册到spring中
    //(url,实体：map ,Class<T> reponseType)
    @Autowired
    private RestTemplate restTemplate;//提供多种便携的访问远程http服务的方法，简单restful服务模板

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //http://localhost:8001/dept/getAll
    //通过ribbon实现的时候应该是一个变量：通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, boolean.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/ById/"+id,Dept.class);
    }
    @GetMapping("/consumer/dept/getAll")
    public List<Dept> queryALL(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/getAll",List.class);
    }


}
