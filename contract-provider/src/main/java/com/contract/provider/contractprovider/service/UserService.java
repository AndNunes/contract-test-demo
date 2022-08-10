package com.contract.provider.contractprovider.service;

import com.contract.provider.contractprovider.model.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    List<User> listUsers();
}
