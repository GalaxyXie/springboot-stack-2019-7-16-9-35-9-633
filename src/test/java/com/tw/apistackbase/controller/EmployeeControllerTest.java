package com.tw.apistackbase.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void should_return_employee_list_when_get_employee_list() throws Exception {
        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"companyName\":\"OOCL\",\"employeesNumber\":2,\"employees\":[{\"id\":4,\"name\":\"alibaba1\",\"age\":20,\"gender\":\"male\"},{\"id\":11,\"name\":\"tengxun2\",\"age\":19,\"gender\":\"female\"}]}]"));

    }
    @Test
    public void should_return_company_when_get_company_by_index() throws Exception {
        mockMvc.perform(get("/companies/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\"companyName\":\"OOCL\",\"employeesNumber\":2,\"employees\":[{\"id\":4,\"name\":\"alibaba1\",\"age\":20,\"gender\":\"male\"},{\"id\":11,\"name\":\"tengxun2\",\"age\":19,\"gender\":\"female\"}]}"));

    }
    @Test
    public void should_return_employees_when_get_employeeList_of_a_company_by_index() throws Exception {
        mockMvc.perform(get("/companies/0/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"id\":4,\"name\":\"alibaba1\",\"age\":20,\"gender\":\"male\"},{\"id\":11,\"name\":\"tengxun2\",\"age\":19,\"gender\":\"female\"}]"));

    }
    @Test
    public void should_return_companies_when_get_companies_by_page_and_pageSize() throws Exception {
        mockMvc.perform(get("/companies?page=1&pageSize=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"companyName\":\"OOCL\",\"employeesNumber\":2,\"employees\":[{\"id\":4,\"name\":\"alibaba1\",\"age\":20,\"gender\":\"male\"},{\"id\":11,\"name\":\"tengxun2\",\"age\":19,\"gender\":\"female\",\"salary\":7000}]}]"));

    }
    @Test
    public void should_return_success_when_create_company_success() throws Exception {
        mockMvc.perform(post("/companies").contentType("application/json;charset=UTF-8")
                .content("{}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("create success"));

    }
    @Test
    public void should_return_company_when_after_update_company() throws Exception {
        mockMvc.perform(put("/companies/0").contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\"companyName\":\"OOCL\",\"employeesNumber\":1,\"employees\":[{\"id\":4,\"name\":\"alibaba1\",\"age\":20,\"gender\":\"male\"},{\"id\":11,\"name\":\"tengxun2\",\"age\":19,\"gender\":\"female\",\"salary\":7000}]}"));

    }
    @Test
    public void should_return_status_when_after_delete_company() throws Exception {
        mockMvc.perform(delete("/companies/0").contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}