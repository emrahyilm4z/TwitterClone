package com.emrah.TwitterClone.controller;

import com.emrah.TwitterClone.dto.request.AddCommentRequestDto;
import com.emrah.TwitterClone.dto.response.CommentResponseDto;
import com.emrah.TwitterClone.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("comment")
public class CommentController {
    private CommentService commentService;

    @PostMapping("add")
    public ResponseEntity<CommentResponseDto> add(@RequestBody AddCommentRequestDto addCommentRequestDto) {
        return new ResponseEntity<>(commentService.add(addCommentRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam (name = "id") int commentId){
        return new ResponseEntity(commentService.delete(commentId), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CommentResponseDto>> getAll(){
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }
}
