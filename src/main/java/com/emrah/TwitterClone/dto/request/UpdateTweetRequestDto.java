package com.emrah.TwitterClone.dto.request;

import lombok.Data;

@Data
public class UpdateTweetRequestDto {
    private int tweetId;
    private String tweetBody;
}
