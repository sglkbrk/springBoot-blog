package com.example.demo.service;


import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getPostCommet(Long id){
        return commentRepository.findAllByPostidOrderByDatetime(id);
    }

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }
}
