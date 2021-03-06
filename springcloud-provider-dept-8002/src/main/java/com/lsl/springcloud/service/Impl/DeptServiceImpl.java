package com.lsl.springcloud.service.Impl;

import com.lsl.springcloud.dao.DeptDao;
import com.lsl.springcloud.pojo.Dept;
import com.lsl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    public List<Dept> queryALL() {
        return deptDao.queryALL();
    }
}
