package com.cansr.sample1.service;

import com.cansr.sample1.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService<T> {
    Optional<List<T>> fetchAllUsers();

    Optional<T> fetchUser(Long Id);

    Boolean saveUser(UserDto userDto);
}
