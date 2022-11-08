package com.emrah.TwitterClone.repository;

import com.emrah.TwitterClone.entities.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
}
