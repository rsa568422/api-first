package com.example.demo.mapper;

import com.example.demo.controller.model.User;
import com.example.demo.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDto(UserEntity user);

    List<User> toDtos(List<UserEntity> users);
}
