package com.emrah.TwitterClone.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateUserRequestDto {
    private int id;
    private String userName;
    private String name;
    private String userInfo;
    private String location;
    private LocalDate birthDay;
}
