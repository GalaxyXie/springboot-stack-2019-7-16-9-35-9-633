package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRespository {
    List<Employee> employees =new ArrayList<>();
    public EmployeeRespository(){
        employees.add(new Employee(4,"alibaba1",20,"male",6000));
        employees.add(new Employee(11,"tengxun2",19,"female",7000));
    };

    public List<Employee> getEmployees() {
        return employees;
    }
}
