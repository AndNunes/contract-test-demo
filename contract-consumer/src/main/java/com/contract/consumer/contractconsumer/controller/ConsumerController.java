package com.contract.consumer.contractconsumer.controller;

import com.contract.consumer.contractconsumer.model.User;
import com.contract.consumer.contractconsumer.model.dto.UserDto;
import com.contract.consumer.contractconsumer.service.ConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) throws IOException {
        return ResponseEntity.ok(consumerService.registerUser(userDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<User>> searchAllUsers() {
        return ResponseEntity.ok(consumerService.searchAllUsers());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<User> searchUser(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(consumerService.searchUser(id));
    }
}
