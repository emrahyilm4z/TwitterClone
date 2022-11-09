package com.emrah.TwitterClone.service;

import com.emrah.TwitterClone.entities.Follower;
import com.emrah.TwitterClone.entities.User;
import com.emrah.TwitterClone.exception.NotFoundUserName;
import com.emrah.TwitterClone.repository.FollowerRepository;
import com.emrah.TwitterClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowerService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public void addOrUnf(String userName, String followName) {
        User user = userRepository.findByUserName(userName).orElseThrow(NotFoundUserName::new);
        Follower follower = modelMapper.map(userRepository.findByUserName(followName), Follower.class);
        Follower follower1 = user.getFollowers().stream().filter(item -> item.getUserName().equals(follower.getUserName())).findAny().orElse(null);
        if(follower1 != null){
            user.unFollower(follower1);
        }else{
            user.addFollower(follower);
        }
        userRepository.saveAndFlush(user);
    }
}
