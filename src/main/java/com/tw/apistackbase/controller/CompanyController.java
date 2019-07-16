package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CompanyController {
    private List<Company>companies=new CompanyRepository().getCompanies();
    @GetMapping("/companies")
    public ResponseEntity getCompanies(){

        return ResponseEntity.ok(companies);
    }
    @GetMapping("/companies/{index}")
    public ResponseEntity getCompanyByIndex(@PathVariable int index){

        return ResponseEntity.ok(companies.get(index));
    }
    @GetMapping("/companies/{index}/employees")
    public ResponseEntity getEmployeesByCompanyIndex(@PathVariable int index){

        return ResponseEntity.ok(companies.get(index).getEmployees());
    }
    @GetMapping("/companies?page={page}&pageSize={pageSize}")
    public ResponseEntity getCompanyByPageAndPageSize(@PathVariable int page,@PathVariable int pageSize){
        List <Company>companies1=new ArrayList<>();
        companies1=companies.stream()
                .filter(company -> companies.indexOf(company)<(page*pageSize)&&
                companies.indexOf(company)>=((page-1)*pageSize))
                .collect(Collectors.toList());
        return ResponseEntity.ok(companies.get(page*pageSize).getEmployees());
    }

}
