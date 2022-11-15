package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.dto.request.AddUserRequestDto;
import com.emrah.TwitterClone.dto.request.UpdateUserRequestDto;
import com.emrah.TwitterClone.dto.response.AddUserResponseDto;
import com.emrah.TwitterClone.dto.response.UserDetailsResponseDto;
import com.emrah.TwitterClone.dto.response.UserResponseDto;
import com.emrah.TwitterClone.entities.User;
import com.emrah.TwitterClone.exception.Message;
import com.emrah.TwitterClone.exception.NotFoundUserId;
import com.emrah.TwitterClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(NotFoundUserId::new);
    }

    public AddUserResponseDto add(AddUserRequestDto addUserRequestDto) {
        User user = modelMapper.map(addUserRequestDto, User.class);
        userRepository.save(user);
        return modelMapper.map(user, AddUserResponseDto.class);
    }

    public String deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundUserId::new);
        userRepository.delete(user);
        return !userRepository.existsById(id) ? Message.SUCCESFULY_DELETED : Message.SOMETHING_WENT_WRONG;
    }

    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream().map(item -> modelMapper.map(item, UserResponseDto.class)).toList();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public String updateUser(UpdateUserRequestDto updateUserRequestDto) {
        User user = userRepository.findById(updateUserRequestDto.getId()).orElseThrow(NotFoundUserId::new);
        user = modelMapper.map(updateUserRequestDto, User.class);
        userRepository.save(user);
        return user.getUserName() + " " + Message.SUCCESFULY_UPDATED;
    }

    public List<UserResponseDto> getAllUsersReTweetByTweetId(int tweetId) {
        return userRepository.findAll().stream().filter(item -> item.getReTweets().containsKey(tweetId)).map(item -> modelMapper.map(item, UserResponseDto.class)).toList();
    }

    public List<UserResponseDto> getAllUsersLikeByTweetId(int tweetId) {
        return userRepository.findAll().stream().filter(item -> item.getLikes().containsKey(tweetId)).map(item -> modelMapper.map(item, UserResponseDto.class)).toList();
    }

    public UserDetailsResponseDto userDetails(int id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundUserId::new);
        return modelMapper.map(user, UserDetailsResponseDto.class);
    }
}
