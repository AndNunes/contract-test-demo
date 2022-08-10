package com.contract.provider.contractprovider.service.impl;

import com.contract.provider.contractprovider.model.User;
import com.contract.provider.contractprovider.repository.UserRepository;
import com.contract.provider.contractprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
