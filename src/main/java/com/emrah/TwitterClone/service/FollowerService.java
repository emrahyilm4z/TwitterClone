package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.entities.Follower;
import com.emrah.TwitterClone.entities.User;
import com.emrah.TwitterClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowerService {
    private UserService userService;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public Boolean add(int id, int userId) {
        User user = userRepository.findById(id).orElseThrow();
        Follower follower = modelMapper.map(userRepository.findById(userId).orElseThrow(), Follower.class);
        user.addFollower(follower);
        userRepository.saveAndFlush(user);
        return true;
    }
}
