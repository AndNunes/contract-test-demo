package com.contract.consumer.contractconsumer.service;

import com.contract.consumer.contractconsumer.model.User;
import com.contract.consumer.contractconsumer.model.dto.UserDto;

import java.io.IOException;
import java.util.List;

public interface ConsumerService {

    User registerUser(UserDto user) throws IOException;

    List<User> searchAllUsers();

    User searchUser(Long id) throws IOException;
}
