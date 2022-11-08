package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.AddUserRequestDto;
import com.emrah.TwitterClone.dto.response.UserResponseDto;
import com.emrah.TwitterClone.entities.Comment;
import com.emrah.TwitterClone.entities.User;
import com.emrah.TwitterClone.exception.Message;
import com.emrah.TwitterClone.exception.NotFoundUserId;
import com.emrah.TwitterClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(NotFoundUserId::new);
    }

    public UserResponseDto add(AddUserRequestDto addUserRequestDto) {
        User user = modelMapper.map(addUserRequestDto, User.class);
        user.setUserCreateDate(LocalDate.now());
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return !userRepository.existsById(id) ? Message.SUCCESFULY_DELETED : Message.SOMETHING_WENT_WRONG;
    }


    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream().map(item -> modelMapper.map(item, UserResponseDto.class)).toList();
    }
}