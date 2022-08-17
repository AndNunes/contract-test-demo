package com.contract.consumer.contractconsumer.contracttest;

import com.contract.consumer.contractconsumer.model.dto.UserDto;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.contract.provider:contract-provider:+:stubs:9000"},
        stubsMode = LOCAL)
public class ContractUserTest {

    private Gson gson;

    @Before
    public void setup() {
        gson = new Gson();
    }

    @Test
    public void shouldReturnAllUsers() throws Exception {

        RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .get("http://localhost:9000/user")
                .then()
                .statusCode(200)
                .body("$", hasSize(2))
                .body("id", hasSize(2))
                .body("name[0]", isA(String.class))
                .body("profession[0]", isA(String.class))
                .body("email[0]", isA(String.class))
                .body("age[0]", isA(Integer.class));
    }

    @Test
    public void shouldReturnUserRegistered() throws Exception {
        UserDto userDto = new UserDto("Anderson Nunes da Silva", "Analista de Sistemas", "anderson.nunes@gmail.com", 28);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(userDto)
                .when()
                .post("http://localhost:9000/user")
                .then()
                .statusCode(202)
                .body("id", isA(Integer.class))
                .body("name", isA(String.class))
                .body("profession", isA(String.class))
                .body("email", isA(String.class))
                .body("age", isA(Integer.class));

    }
}
