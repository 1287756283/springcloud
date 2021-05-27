package com.lsl.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {//实体类
/*链式写法：
* 原来的
* Dept dept = new Dept();
* dept.setDeptno();
* dept.setDeptname();
* 链式写法：
* dept.setDeptno().setDeptname();
 * dept.setDeptname();
* */
    private Long deptno;
    private String deptname;
    //数据库说明，看数据库是属于哪个微服务
    private String db_source;

    public Dept(String deptname) {
        this.deptname = deptname;
    }
}
