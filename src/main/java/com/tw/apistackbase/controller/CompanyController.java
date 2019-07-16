package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {
    private List<Company>companies=new CompanyRepository().getCompanies();
    @GetMapping("/companies")
    public ResponseEntity getCompanies(){

        return ResponseEntity.ok(companies);
    }
    @GetMapping("/companies/{index}")
    public ResponseEntity getCompaniesByIndex(@PathVariable int index){

        return ResponseEntity.ok(companies.get(index));
    }

}
