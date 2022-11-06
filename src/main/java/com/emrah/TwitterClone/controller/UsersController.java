package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.AddUserRequestDto;
import com.emrah.TwitterClone.dto.response.UserResponseDto;
import com.emrah.TwitterClone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UsersController {
    private UserService userService;

    @PostMapping("add")
    public ResponseEntity<UserResponseDto> add(@RequestBody AddUserRequestDto addUserRequestDto) {
        return new ResponseEntity<>(userService.add(addUserRequestDto), HttpStatus.OK);
    }
}
