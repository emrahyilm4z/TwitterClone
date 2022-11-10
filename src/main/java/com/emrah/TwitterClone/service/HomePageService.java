package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.response.HomePageResponse;
import com.emrah.TwitterClone.entities.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HomePageService {
    private UserService userService;
    private TweetService tweetService;

    public List<HomePageResponse> getAll() {
        List<Tweet> tweet = tweetService.findAll().stream().filter(item -> item.getParent() == 0).toList();
        List<HomePageResponse> homePageResponses = new ArrayList<>();
        for (Tweet tweet1 : tweet) {
            HomePageResponse homePageResponse = new HomePageResponse();
            homePageResponse.setTime(tweet1.getTweetCreateDate());
            homePageResponse.setUserName(tweet1.getUser().getUserName());
            homePageResponse.setTweetBody(tweet1.getTweetBody());
            homePageResponse.setReTweetUserName(userService.getAllUsersReTweetByTweetId(tweet1.getTweetId()));
            homePageResponse.setLikeUserName(userService.getAllUsersLikeByTweetId(tweet1.getTweetId()));
            homePageResponse.setCommentBody(tweetService.getAllCommentOfTweetByTweetId(tweet1.getTweetId()));
            homePageResponses.add(homePageResponse);
        }
        return homePageResponses;
    }
}
