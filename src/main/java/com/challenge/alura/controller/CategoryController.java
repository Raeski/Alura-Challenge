package com.challenge.alura.controller;

import com.challenge.alura.model.Category;
import com.challenge.alura.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("delete/{id}")
    private void deleleteVideoById(@PathVariable Long id ) {
        categoryService.deleteVideo(id);
    }

    @GetMapping()
    private List<Category> listAllCategory() {
        return categoryService.categoryList();
    }

}
