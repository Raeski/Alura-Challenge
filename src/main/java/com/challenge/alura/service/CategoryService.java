package com.challenge.alura.service;

import com.challenge.alura.exception.BadRequestException;
import com.challenge.alura.model.Category;
import com.challenge.alura.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ResponseEntity<Category> saveCategory ( Category category) {
        try{
            return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.CREATED);
        } catch (BadRequestException e) {
            throw new BadRequestException("Fail to create category!", e.getMessage());
        }
    }

    public Category getCategoryById ( Long id ) {

        return categoryRepository.findById(id).orElseThrow(() -> new BadRequestException("Fail to find category"));
    }


    public void deleteVideo ( Long id ) {

        Category category = getCategoryById(id);
        try {
            categoryRepository.deleteById(category.getId());
        } catch (BadRequestException exception) {
            exception.getMessage();
        }
    }

    public List<Category> categoryList () {
        return categoryRepository.findAll();
    }

}
