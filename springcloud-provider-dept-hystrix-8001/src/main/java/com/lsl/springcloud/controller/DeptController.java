package com.lsl.springcloud.controller;

import com.lsl.springcloud.pojo.Dept;
import com.lsl.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务！
@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    //方案一
    @GetMapping("/ById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet" )
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
//        if (dept == null){
//            throw new RuntimeException("id"+id+"不存在");
//        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
       return new Dept()
               .setDeptno(id)
               .setDeptname("id"+id+"不存在-hystrix")
               .setDb_source("no datdsource");
    }

}
