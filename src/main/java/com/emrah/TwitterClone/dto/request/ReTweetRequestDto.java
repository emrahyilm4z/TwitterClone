package com.emrah.TwitterClone.dto.request;

import lombok.Data;

@Data
public class ReTweetRequestDto {
    private int userId;
    private int tweetId;
}
