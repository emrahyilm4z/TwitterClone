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
    public ResponseEntity addOrUnf(@RequestParam (name = "user") String userName, @RequestParam (name = "follow user") String followName){
        followService.addOrUnf(userName,followName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
