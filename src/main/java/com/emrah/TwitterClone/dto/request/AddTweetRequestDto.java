package com.emrah.TwitterClone.dto.request;

import lombok.Data;

@Data
public class AddTweetRequestDto {
    private int userId;
    private int parent;
    private String tweetBody;
}
