package com.lsl.springcloud.controller;

import com.lsl.springcloud.pojo.Dept;
import com.lsl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //理解：消费者，不应该有<dependency>
    //支持RestFul风格
    //RestTemplate ....供我们直接调用，注册到spring中
    //(url,实体：map ,Class<T> reponseType)
//    @Autowired
//    private RestTemplate restTemplate;//提供多种便携的访问远程http服务的方法，简单restful服务模板

    @Autowired
    private DeptClientService deptClientService = null;


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.addDept(dept);
    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }
    @RequestMapping("/consumer/dept/getAll")
    public List<Dept> queryALL(){
        return deptClientService.queryALL();
    }


}
