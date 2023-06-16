package com.ea.commentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ea.commentservice.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
