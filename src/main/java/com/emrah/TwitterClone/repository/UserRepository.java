package com.emrah.TwitterClone.repository;

import com.emrah.TwitterClone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
