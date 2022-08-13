package com.contract.provider.contractprovider.service.impl;

import com.contract.provider.contractprovider.model.User;
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
    public User registerUser(User user) {
        Optional<User> userExist = userRepository.findById(user.getCpf());

        if(userExist.isPresent()) {
            throw new RuntimeException("Usuário Existente");
        }else {
            return userRepository.save(user);
        }
    }

    @Override
    public List<User> listUsers() {

        List<User> listaUsers = userRepository.findAll();

        if (listaUsers.isEmpty()) {
           throw new  RuntimeException("Nenhum Cliente Encontrado");
        }
        return userRepository.findAll();
    }

    @Override
    public User searchUser(String cpf) {

        Optional<User> user = userRepository.findById(cpf);
        return userRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Usuario não encontrado: " + cpf));
    }
}
