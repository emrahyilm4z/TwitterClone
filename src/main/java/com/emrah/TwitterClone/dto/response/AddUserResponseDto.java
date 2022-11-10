package com.emrah.TwitterClone.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddUserResponseDto {
    private String userName;
    private String name;
    private String userInfo;
    private String location;
    private LocalDate birthDay;
}
