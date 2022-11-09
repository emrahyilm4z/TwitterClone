package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.LikeRequestDto;
import com.emrah.TwitterClone.entities.Tweet;
import com.emrah.TwitterClone.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeService {
    private UserService userService;
    private TweetService tweetService;

    public void like(LikeRequestDto likeRequestDto) {
        User user = userService.findById(likeRequestDto.getUserId());
        Tweet tweet = tweetService.findById(likeRequestDto.getTweetId());
        if (user.getLikes().contains(tweet.getTweetId())) {
            user.noLike(tweet.getTweetId());
        } else {
            user.like(tweet.getTweetId());
        }
        userService.save(user);
    }
}