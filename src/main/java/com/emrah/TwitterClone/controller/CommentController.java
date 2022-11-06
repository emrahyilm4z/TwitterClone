package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.AddCommentRequestDto;
import com.emrah.TwitterClone.dto.response.CommentResponseDto;
import com.emrah.TwitterClone.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("comment")
public class CommentController {
    private CommentService commentService;

    @PostMapping("add")
    public ResponseEntity<CommentResponseDto> add(@RequestBody AddCommentRequestDto addCommentRequestDto) {
        return new ResponseEntity<>(commentService.add(addCommentRequestDto), HttpStatus.OK);
    }
}
