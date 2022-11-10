package com.emrah.TwitterClone.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HomePageResponse {
    private LocalDateTime time;
    private String userName;
    private String tweetBody;
    private List<UserResponseDto> reTweetUserName;
    private List<UserResponseDto> likeUserName;
    private List<TweetResponseDto> commentBody;


}
