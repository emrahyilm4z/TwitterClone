package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.entities.Follower;
import com.emrah.TwitterClone.entities.User;
import com.emrah.TwitterClone.exception.NotFoundUserName;
import com.emrah.TwitterClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowerService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public void addOrUnf(int userId, int followId) {
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserName::new);
        Follower follower = modelMapper.map(userRepository.findById(followId), Follower.class);
        Follower follower1 = user.getFollowers().stream().filter(item -> item.getId() == follower.getId()).findAny().orElse(null);
        if (follower1 != null) {
            user.unFollower(follower1);
        } else {
            user.addFollower(follower);
        }
        userRepository.save(user);
    }
}
