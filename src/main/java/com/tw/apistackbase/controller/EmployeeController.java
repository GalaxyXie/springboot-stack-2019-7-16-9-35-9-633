package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.CompanyRepository;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.model.EmployeeRespository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeController {
    EmployeeRespository employeeRespository=new EmployeeRespository();
    private List<Employee> employees=employeeRespository.getEmployees();
    @GetMapping("/employees")
    public ResponseEntity getEmployees(){

        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employees/{index}")
    public ResponseEntity getEmployeeByIndex(@PathVariable int index){

        return ResponseEntity.ok(employees.get(index));
    }

    @GetMapping("/employees?page={page}&pageSize={pageSize}")
    public ResponseEntity getEmployeesByPageAndPageSize(@PathVariable int page,@PathVariable int pageSize){
        List <Employee>employees1=new ArrayList<>();
        employees1=employees.stream()
                .filter(employee -> employees.indexOf(employee)<(page*pageSize)&&
                        employees.indexOf(employee)>=((page-1)*pageSize))
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees1);
    }
    @GetMapping("/employees?gender={gender}")
    public ResponseEntity getEmployeesByGendeer(@PathVariable String gender){
        List <Employee>employees1=new ArrayList<>();
        employees1=employees.stream()
                .filter(employee -> employee.getGender().equals("male"))
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees1);
    }
    @PostMapping("/employees")
    public ResponseEntity createEmployees(@RequestBody Employee employee){
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("create success");
    }
    @PutMapping("/employees/{index}")
    public ResponseEntity updateEmployees(@PathVariable int index){
       Employee employee=employees.get(index);
        employee.setSalary(10000);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/employees/{index}")
    public void DeleteEmployees(@PathVariable int index){
        employees.remove(index);
    }
}
