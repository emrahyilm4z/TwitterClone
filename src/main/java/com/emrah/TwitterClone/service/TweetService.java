package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.AddTweetRequestDto;
import com.emrah.TwitterClone.dto.response.TweetResponseDto;
import com.emrah.TwitterClone.entities.Tweet;
import com.emrah.TwitterClone.exception.NotFoundTweetID;
import com.emrah.TwitterClone.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class TweetService {
    private TweetRepository tweetRepository;
    private UserService userService;
    private ModelMapper modelMapper;

    public TweetResponseDto add(AddTweetRequestDto addTweetRequestDto) {
        Tweet tweet = modelMapper.map(addTweetRequestDto, Tweet.class);
        tweet.setTweetCreateDate(LocalDate.now());
        tweet.setUser(userService.findById(addTweetRequestDto.getUser_id()));
        tweetRepository.save(tweet);
        return modelMapper.map(tweet, TweetResponseDto.class);
    }
    public Tweet findById(int id){
        return tweetRepository.findById(id).orElseThrow(NotFoundTweetID::new);
    }
}
