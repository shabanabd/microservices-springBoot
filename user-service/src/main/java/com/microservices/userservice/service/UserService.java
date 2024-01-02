package com.microservices.userservice.service;

import com.microservices.userservice.dto.ResponseDto;
import com.microservices.userservice.model.User;

public interface UserService {

    User createUser(User user);
    ResponseDto getUser(Long userId);
}
