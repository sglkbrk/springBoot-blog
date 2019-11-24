package com.example.demo.controller;


import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("CommentService")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/getPostCommet/{postid}")
    public List<Comment> getPostCommet(@PathVariable(value = "postid") Long id) {
        return commentService.getPostCommet(id);

    }

    @PostMapping("/addComment")
    public Comment addComment(@Valid @RequestBody Comment comment) {
        return commentService.addComment(comment);

    }

}
