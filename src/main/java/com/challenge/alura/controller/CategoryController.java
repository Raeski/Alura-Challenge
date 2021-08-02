package com.challenge.alura.controller;

import com.challenge.alura.model.Category;
import com.challenge.alura.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping
    private ResponseEntity<Category> createCategory(@RequestBody Category category) {

        return categoryService.saveCategory(category);
    }


}
