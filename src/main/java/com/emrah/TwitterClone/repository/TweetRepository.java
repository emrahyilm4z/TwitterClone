package com.emrah.TwitterClone.repository;

import com.emrah.TwitterClone.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Integer> { }
