package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

//    public Category getCategory(Long id){
//        return  categoryRepository.findFirstByIdAndActive(id,"X");
//    }

    public Category getCategory(String url){
        return  categoryRepository.findFirstByUrlAndActive(url,"X");
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAllByAndActive("X");
    }
}
