package com.emrah.TwitterClone.dto.request;

import lombok.Data;

@Data
public class LikeRequestDto {
    private int userId;
    private int tweetId;
}
