package com.emrah.TwitterClone.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDetailsResponseDto {
    private String userName;
    private String name;
    private String userInfo;
    private String location;
    private LocalDate birthDay;
    private LocalDateTime userCreateDate;

}
