package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Cacheable;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository.findFirstById(id);
    }
    public Post getPost(String id) {
        return postRepository.findAllByUrl(id);
    }

    public List<Post> getCategoryPosts(Long id ,int pagno) {
        Pageable sortedByName = PageRequest.of(pagno, 5, Sort.by("date"));
        return postRepository.findAllByCategAndActive(id,sortedByName,"X");
    }

    public List<Post> getAllCategoryPosts(Long id) {
        return postRepository.findAllByCategAndActive(id,"X");
    }

    public List<Post> getBannerPost() {
        return postRepository.findAllByBannerPostAndActive("X","X");
    }

    public List<Post> getAllPost(int id){
        Pageable sortedByName = PageRequest.of(id, 6, Sort.by("date").descending());
        return postRepository.findAllByAndActive(sortedByName,"X");
    }
    public List<Post> getAllSearchPost(String text){
        Pageable sortedByName = PageRequest.of(0, 20, Sort.by("date").descending());
        return postRepository.findAllByTitleContainsAndActive(text,"X",sortedByName);
    }

    public Long getAllPostCount(){
        return postRepository.countAllByActive("X");
    }

    public Long getAllPostCategoryCount(Long id){
        return postRepository.countAllByCategAndActive(id,"X");
    }

    public List<Post> getPopularPost(){
        Pageable sortedByName = PageRequest.of(0, 4, Sort.by("size").descending());
        return postRepository.findAllByAndActive(sortedByName,"X");
    }

    public void setSizePost(Long id){
        Post post = postRepository.findFirstById(id);
        if (post != null){
            Long size = post.getSize();
            post.setSize(size+1);
            postRepository.save(post);
        }
    }

}
