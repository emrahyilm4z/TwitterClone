package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.AddTweetRequestDto;
import com.emrah.TwitterClone.dto.response.TweetResponseDto;
import com.emrah.TwitterClone.dto.response.UserResponseDto;
import com.emrah.TwitterClone.service.TweetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("tweet")
public class TweetsController {
    private TweetService tweetService;

    @PostMapping("add")
    public ResponseEntity<TweetResponseDto> add(@RequestBody AddTweetRequestDto addTweetRequestDto) {
        return new ResponseEntity<>(tweetService.add(addTweetRequestDto), HttpStatus.OK);
    }
}
