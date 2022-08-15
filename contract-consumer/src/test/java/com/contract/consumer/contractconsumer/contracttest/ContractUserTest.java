package com.contract.consumer.contractconsumer.contracttest;

import com.contract.consumer.contractconsumer.model.dto.UserDto;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(ids = {"com.contract.provider:contract-provider:+:stubs:9000"},
        stubsMode = LOCAL)
public class ContractUserTest {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    @Before
    public void setup() {
        gson = new Gson();
    }

    @Test
    public void shouldReturnAllUsers() throws Exception {
        this.mockMvc.perform(
                get("/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", Matchers.isA(Integer.class)))
                .andExpect(jsonPath("$[0].name", Matchers.isA(String.class)))
                .andExpect(jsonPath("$[0].profession", Matchers.isA(String.class)))
                .andExpect(jsonPath("$[0].email", Matchers.isA(String.class)))
                .andExpect(jsonPath("$[0].age", Matchers.isA(Integer.class)));
    }

    @Test
    public void shouldReturnUserRegistered() throws Exception {
        UserDto userDto = new UserDto("Anderson Nunes da Silva", "Analista de Sistemas", "anderson.nunes@gmail.com", 28);

        this.mockMvc.perform(
                post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(userDto)))
                .andExpect(jsonPath("$.id", Matchers.isA(Integer.class)))
                .andExpect(jsonPath("$.name", is("Anderson Nunes da Silva")))
                .andExpect(jsonPath("$.profession", Matchers.isA(String.class)))
                .andExpect(jsonPath("$.email", Matchers.isA(String.class)))
                .andExpect(jsonPath("$.age", Matchers.isA(Integer.class)));
    }
}
