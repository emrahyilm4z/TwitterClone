package com.emrah.TwitterClone.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TweetDetailsResponseDto {
    private String userName;
    private String tweetBody;
    private LocalDateTime tweetCreateDate;
    private LocalDateTime tweetUpdateDate;

}
