package com.example.demo.controller;


import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("CategoryService")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    PostService postService;

    @GetMapping("/getCategory/{url}")
    public Category getAllCategory(@PathVariable(value = "url") String url) {
        return categoryService.getCategory(url);
    }

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory() {
        List<Category>  categories = categoryService.getAllCategory();
        for(Category category : categories) {
            Long sy = new Long (postService.getAllCategoryPosts(category.getId()).size());
            category.setSize(sy);
        }
        return categories;

    }
}
