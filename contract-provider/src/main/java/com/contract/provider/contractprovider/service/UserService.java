package com.contract.provider.contractprovider.service;

import com.contract.provider.contractprovider.model.User;
import com.contract.provider.contractprovider.model.dto.UserDto;

import java.util.List;

public interface UserService {

    User registerUser(UserDto userDto);

    List<User> listUsers();

    User searchUser(Long id);
}
