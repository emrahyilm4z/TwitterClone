package com.emrah.TwitterClone.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDto {
    private String userName;
    private String name;
    private Set<FollowersResponseDto> followers;
}
