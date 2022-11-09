package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.ReTweetRequestDto;
import com.emrah.TwitterClone.entities.Tweet;
import com.emrah.TwitterClone.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RetweetService {
    private UserService userService;
    private TweetService tweetService;

    public void reTweet(ReTweetRequestDto reTweetRequestDto) {
        User user = userService.findById(reTweetRequestDto.getUserId());
        Tweet tweet = tweetService.findById(reTweetRequestDto.getTweetId());
        if (user.getReTweets().containsKey(tweet.getTweetId())) {
            user.undoReTweet(tweet.getTweetId());
        } else {
            user.reTweet(tweet.getTweetId(), LocalDateTime.now());
        }
        userService.save(user);
    }
}
