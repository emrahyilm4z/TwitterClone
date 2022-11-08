package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.AddTweetRequestDto;
import com.emrah.TwitterClone.dto.response.TweetResponseDto;
import com.emrah.TwitterClone.dto.response.UserResponseDto;
import com.emrah.TwitterClone.service.TweetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("tweet")
public class TweetsController {
    private TweetService tweetService;
    @PostMapping("add")
    public ResponseEntity<TweetResponseDto> add(@RequestBody AddTweetRequestDto addTweetRequestDto) {
        return new ResponseEntity<>(tweetService.add(addTweetRequestDto), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TweetResponseDto>> getAll(){
        return new ResponseEntity<>(tweetService.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("deleteTweet")
    public ResponseEntity<String> deleteTweet(@RequestParam (name = "tweetId") int tweetId){
        return new ResponseEntity<>(tweetService.deleteTweet(tweetId), HttpStatus.OK);
    }
}
