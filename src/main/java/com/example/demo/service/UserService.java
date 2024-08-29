package com.example.demo.service;

import com.example.demo.controller.model.User;
import com.example.demo.controller.model.UserInput;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<User> get() {
        return userMapper.toDtos(userRepository.findAll());
    }

    public Optional<User> get(Integer userId) {
        return userRepository.findById(userId).map(userMapper::toDto);
    }

    public User put(UserInput userInput) {
        var user = UserEntity.builder()
                .name(userInput.getName())
                .email(userInput.getEmail())
                .createdAt(OffsetDateTime.now()).build();
        return userMapper.toDto(userRepository.save(user));
    }
}
