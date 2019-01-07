package com.cheer.spring.dao.Impl;

import com.cheer.spring.dao.EmpDao;
import com.cheer.spring.model.Emp;

public class EmpDaoImpl implements EmpDao {

    @Override
    public Emp getEmp() {
        Emp emp=new Emp();
        emp.setName("爱吔屎的咣咣咣");
        return emp;
    }
}
