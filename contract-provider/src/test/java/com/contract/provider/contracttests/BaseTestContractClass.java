package com.contract.provider.contracttests;

import com.contract.provider.contractprovider.controller.UserController;
import com.contract.provider.contractprovider.model.User;
import com.contract.provider.contractprovider.model.dto.UserDto;
import com.contract.provider.contractprovider.service.UserService;
import com.contract.provider.contractprovider.service.impl.UserServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class BaseTestContractClass {

    @Before
    public void setup() {

        User anderson = new User(new UserDto("Anderson Nunes da Silva", "Analista de Sistemas", "anderson.nunes@gmail.com", 28));

        anderson.setId(Long.parseLong("1"));

        User francisco = new User(new UserDto("Francisco de Assis", "Vigia", "francisco.assis@gmail.com", 53));

        francisco.setId(Long.parseLong("2"));

        List<User> usersList = Arrays.asList(
                anderson,
                francisco);

        UserService userService = Mockito.mock(UserServiceImpl.class);

        given(userService.listUsers()).willReturn(usersList);
        given(userService.registerUser(any())).willReturn(anderson);

        RestAssuredMockMvc.standaloneSetup(new UserController(userService));
    }

}
