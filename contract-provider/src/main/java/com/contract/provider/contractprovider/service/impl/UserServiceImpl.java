package com.contract.provider.contractprovider.service.impl;

import com.contract.provider.contractprovider.model.User;
import com.contract.provider.contractprovider.model.dto.UserDto;
import com.contract.provider.contractprovider.repository.UserRepository;
import com.contract.provider.contractprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto) {

        User user = new User(userDto);

        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {

        List<User> listUsers = userRepository.findAll();

        if (listUsers.isEmpty()) {
           throw new  RuntimeException("Nenhum Cliente Encontrado");
        }
        return userRepository.findAll();
    }

    @Override
    public User searchUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado: " + id));
    }
}
