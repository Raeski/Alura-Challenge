package com.challenge.alura.controller;

import com.challenge.alura.model.Category;
import com.challenge.alura.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping
    private ResponseEntity<Category> createCategory(@RequestBody Category category) {

        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }


}
