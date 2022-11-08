package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.AddUserRequestDto;
import com.emrah.TwitterClone.dto.response.UserResponseDto;
import com.emrah.TwitterClone.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UsersController {
    private UserService userService;

    @PostMapping("add")
    public ResponseEntity<UserResponseDto> add(@RequestBody AddUserRequestDto addUserRequestDto) {
        return new ResponseEntity<>(userService.add(addUserRequestDto), HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<UserResponseDto>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
