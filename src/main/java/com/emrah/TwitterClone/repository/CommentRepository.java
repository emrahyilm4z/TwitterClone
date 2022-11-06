package com.emrah.TwitterClone.repository;

import com.emrah.TwitterClone.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
