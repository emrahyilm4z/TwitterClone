package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.service.FollowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("follow")
public class FollowerController {
    private FollowerService followService;

    @PostMapping("add")
    public ResponseEntity<Boolean> add(@RequestParam (name = "id") int id, @RequestParam (name = "userId") int userId){
        return new ResponseEntity<>(followService.add(id,userId),HttpStatus.OK);
    }
}
