package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findFirstById(Long id) ;

    Post findAllByUrl(String url);

    List<Post> findAllByBannerPostAndActive(String value,String active);

    List<Post> findAllByCategAndActive(Long id , Pageable pag,String active);

    List<Post> findAllByTitleContainsAndActive (String value ,String active , Pageable pag);

    List<Post> findAllByCategAndActive(Long id,String active);

    List<Post> findAllByAndActive(Pageable pag,String active);

    Long countAllByActive (String active);

    Long countAllByCategAndActive(Long id,String active);



}
