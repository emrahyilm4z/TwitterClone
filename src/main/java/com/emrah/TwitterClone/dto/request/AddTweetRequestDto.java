package com.emrah.TwitterClone.dto.request;

import lombok.Data;

@Data
public class AddTweetRequestDto {
    private int user_id;
    private String tweetBody;
}
