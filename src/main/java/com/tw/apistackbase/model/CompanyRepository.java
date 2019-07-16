package com.tw.apistackbase.model;

import com.tw.apistackbase.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    List<Company>companies =new ArrayList<>();

    public CompanyRepository() {
        EmployeeRespository employeeRespository=new EmployeeRespository();
        companies.add(new Company("OOCL",2,employeeRespository.getEmployees()));
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
