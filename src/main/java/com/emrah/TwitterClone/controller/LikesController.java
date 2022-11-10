package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.LikeRequestDto;
import com.emrah.TwitterClone.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("like")
public class LikesController {
    private LikeService likeService;

    @PostMapping
    public ResponseEntity like(@RequestBody LikeRequestDto likeRequestDto) {
        likeService.like(likeRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
