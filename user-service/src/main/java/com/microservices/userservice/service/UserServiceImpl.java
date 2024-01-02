package com.microservices.userservice.service;

import com.microservices.userservice.dto.DepartmentDto;
import com.microservices.userservice.dto.ResponseDto;
import com.microservices.userservice.dto.UserDto;
import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        Optional<User> response = userRepository.findById(userId);
        if (response.isPresent()) {
            ResponseDto responseDto = new ResponseDto();
            User user = response.get();
            UserDto userDto = convertUserToDto(user);
            ResponseEntity<DepartmentDto> responseEntity = restTemplate
                    .getForEntity("http://API-GATEWAY/api/departments/" + user.getDepartmentId(),
                            DepartmentDto.class);
            DepartmentDto departmentDto = responseEntity.getBody();
            responseDto.setUser(userDto);
            responseDto.setDepartment(departmentDto);
            return responseDto;
        } else {
            return null;
        }
    }

    private UserDto convertUserToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmailId());
        return userDto;
    }
}
