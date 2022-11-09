package com.emrah.TwitterClone.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReTweetRequestDto {
    private int userId;
    private int tweetId;
}
