package com.example.demo.controller;

import com.example.demo.controller.api.UsersApi;
import com.example.demo.controller.model.User;
import com.example.demo.controller.model.UserInput;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<User>> usersGet() {
        var users = userService.get();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.of(Optional.of(users));
    }

    @Override
    public ResponseEntity<User> usersPost(UserInput userInput) {
        return ResponseEntity.of(Optional.of(userService.put(userInput)));
    }

    @Override
    public ResponseEntity<User> usersUserIdGet(Integer userId) {
        return ResponseEntity.of(userService.get(userId));
    }
}
