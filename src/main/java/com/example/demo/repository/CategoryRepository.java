package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findFirstByIdAndActive(Long id,String active);

    Category findFirstByUrlAndActive(String url,String active);

    List<Category> findAllByAndActive(String active);


}
