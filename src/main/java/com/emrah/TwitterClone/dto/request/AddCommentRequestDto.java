package com.emrah.TwitterClone.dto.request;

import lombok.Data;

@Data
public class AddCommentRequestDto {
    private int user_id;
    private int tweet_id;
    private String commentBody;
}
