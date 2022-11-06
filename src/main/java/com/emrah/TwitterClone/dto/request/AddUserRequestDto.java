package com.emrah.TwitterClone.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddUserRequestDto {
    private String userName;
    private String name;
    private String userInfo;
    private String location;
    private LocalDate birthDay;
}
