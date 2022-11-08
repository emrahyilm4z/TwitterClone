package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.AddCommentRequestDto;
import com.emrah.TwitterClone.dto.response.CommentResponseDto;
import com.emrah.TwitterClone.entities.Comment;
import com.emrah.TwitterClone.exception.Message;
import com.emrah.TwitterClone.exception.NotFoundCommentId;
import com.emrah.TwitterClone.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;
    private TweetService tweetService;
    private UserService userService;
    private ModelMapper modelMapper;
    public CommentResponseDto add(AddCommentRequestDto addCommentRequestDto){
        Comment comment = modelMapper.map(addCommentRequestDto, Comment.class);
        comment.setCommentCreateDate(LocalDate.now());
        comment.setTweet(tweetService.findById(addCommentRequestDto.getTweet_id()));
        comment.setUser(userService.findById(addCommentRequestDto.getUser_id()));
        commentRepository.save(comment);
        return modelMapper.map(comment,CommentResponseDto.class);
    }

    public String delete(int commentId) {
        commentRepository.deleteById(commentId);
        return !commentRepository.existsById(commentId)  ? Message.SUCCESFULY_DELETED : Message.SOMETHING_WENT_WRONG ;
    }

    public List<CommentResponseDto> getAll() {
        return commentRepository.findAll().stream().map(item -> modelMapper.map(item , CommentResponseDto.class)).toList();
    }
}
