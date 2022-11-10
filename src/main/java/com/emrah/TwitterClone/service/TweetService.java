package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.AddTweetRequestDto;
import com.emrah.TwitterClone.dto.request.UpdateTweetRequestDto;
import com.emrah.TwitterClone.dto.response.TweetResponseDto;
import com.emrah.TwitterClone.entities.Tweet;
import com.emrah.TwitterClone.exception.Message;
import com.emrah.TwitterClone.exception.NotFoundTweetID;
import com.emrah.TwitterClone.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {
    private TweetRepository tweetRepository;
    private UserService userService;
    private ModelMapper modelMapper;

    public TweetResponseDto add(AddTweetRequestDto addTweetRequestDto) {
        Tweet tweet = new Tweet();
        tweet.setParent(addTweetRequestDto.getParent());
        tweet.setTweetBody(addTweetRequestDto.getTweetBody());
        tweet.setUser(userService.findById(addTweetRequestDto.getUserId()));
        tweetRepository.save(tweet);
        return modelMapper.map(tweet, TweetResponseDto.class);
    }

    public Tweet findById(int id) {
        return tweetRepository.findById(id).orElseThrow(NotFoundTweetID::new);
    }

    public String deleteTweet(int tweetId) {
        tweetRepository.deleteById(tweetId);
        return !tweetRepository.existsById(tweetId) ? Message.SUCCESFULY_DELETED : Message.SOMETHING_WENT_WRONG;
    }

    public String update(UpdateTweetRequestDto updateTweetRequestDto) {
        Tweet tweet = tweetRepository.findById(updateTweetRequestDto.getTweetId()).orElseThrow(NotFoundTweetID::new);
        if (tweet.getTweetCreateDate().plusMinutes(60).isAfter(LocalDateTime.now())) {
            tweet.setTweetBody(updateTweetRequestDto.getTweetBody());
            tweetRepository.save(tweet);
        } else {
            return Message.CANT_UPDATE_TWEET;
        }
        return Message.SUCCESFULY_UPDATED;
    }

    public List<TweetResponseDto> getAllCommentOfTweetByTweetId(int tweetId) {
        return tweetRepository.findAll().stream().filter(item -> item.getParent() == tweetId).map(item -> modelMapper.map(item, TweetResponseDto.class)).toList();
    }

    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }
}
