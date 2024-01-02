package com.microservices.userservice.controller;

import com.microservices.userservice.dto.ResponseDto;
import com.microservices.userservice.model.User;
import com.microservices.userservice.service.SequenceGeneratorService;
import com.microservices.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId){
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createProduct(@RequestBody User user){
        user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }
}
