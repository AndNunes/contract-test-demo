package com.contract.provider.contractprovider.controller;


import com.contract.provider.contractprovider.model.User;
import com.contract.provider.contractprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<User> searchUser(@PathVariable String cpf) {
        User userResponse = userService.searchUser(cpf);

        return ResponseEntity.ok(userResponse);
    }
}
