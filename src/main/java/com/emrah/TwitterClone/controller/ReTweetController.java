package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.ReTweetRequestDto;
import com.emrah.TwitterClone.service.RetweetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("retweet")
public class ReTweetController {

    private RetweetService retweetService;

    @PostMapping
    public ResponseEntity reTweet(@RequestBody ReTweetRequestDto reTweetRequestDto){
        retweetService.reTweet(reTweetRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
