package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Cacheable;
import java.util.List;

@RequestMapping("PostService")
@RestController
public class PostConroller {

    @Autowired
    PostService postService;

//    @GetMapping("/getPost/{id}")
//    public Post getPost(@PathVariable(value = "id") Long id) {
//        return postService.getPost(id);
//    }

    @GetMapping("/getPost/{url}")
    public Post getPost(@PathVariable(value = "url") String id) {
        return postService.getPost(id);
    }

    @GetMapping("/getCategoryPosts/{id}/{pagno}")
    public List<Post> getCategoryPosts(@PathVariable(value = "id") Long id , @PathVariable(value = "pagno") int pagno) {
        return postService.getCategoryPosts(id,pagno);
    }

    @GetMapping("/getAllPost/{id}")
    public List<Post> getAllPost(@PathVariable(value = "id") int id) {
        return postService.getAllPost(id);
    }

    @GetMapping("/getAllSearchPost/{value}")
    public List<Post> getAllSearchPost(@PathVariable(value = "value") String value) {
        return postService.getAllSearchPost(value);
    }


    @GetMapping("/getPopularPost")
    public List<Post> getPopularPost() {
        return postService.getPopularPost();
    }

    @GetMapping("/getBannerPost")
    public List<Post> getBannerPost() {
        return postService.getBannerPost();
    }


    @GetMapping("/getAllPostCount")
    public Long countAllBy() {
        return postService.getAllPostCount();
    }

    @GetMapping("/getAllPostCategoryCount/{id}")
    public Long getAllPostCategoryCount(@PathVariable(value = "id") Long id) {
        return postService.getAllPostCategoryCount(id);
    }

    @GetMapping("/setSizePost/{url}")
    public void setSizePost(@PathVariable(value = "url") String url){
        postService.setSizePost(url);
    }
}
