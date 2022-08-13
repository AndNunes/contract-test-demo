package com.contract.consumer.contractconsumer.service;

import com.contract.consumer.contractconsumer.model.User;

import java.io.IOException;
import java.util.List;

public interface ConsumerService {

    User registerUser(User user) throws IOException;

    List<User> searchAllUsers();

    User searchUser(String cpf) throws IOException;
}
