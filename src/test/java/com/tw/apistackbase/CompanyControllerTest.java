package com.tw.apistackbase;

import com.tw.apistackbase.model.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void should_return_company_list_when_get_company_list() throws Exception {
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
}
