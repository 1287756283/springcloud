package com.lsl.springcloud.controller;

import com.lsl.springcloud.pojo.Dept;
import com.lsl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务！
@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return true;
    }

    @GetMapping("/ById/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/getAll")
    public List<Dept> queryALL(){
        return deptService.queryALL();
    }

    //注册进来的微服务要提供一些消息
    @GetMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:"+services);
        //得到一个具体的微服务信息,通过具体的微服务id applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+'-'+
                    instance.getPort()+'-'+
                    instance.getUri() +'-'+
                    instance.getServiceId()
            );
        }
        return this.client;
    }
}
