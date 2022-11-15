package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.response.HomePageResponse;
import com.emrah.TwitterClone.service.HomePageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping()
public class HomePageController {
    private HomePageService homePageService;
    @GetMapping()
    public ResponseEntity<List<HomePageResponse>> getAll() {
        return new ResponseEntity<>(homePageService.getAll(), HttpStatus.OK);
    }
}
