package com.challenge.alura.service;

import com.challenge.alura.exception.BadRequestException;
import com.challenge.alura.model.Category;
import com.challenge.alura.model.CategoryUpdate;
import com.challenge.alura.model.Video;
import com.challenge.alura.model.VideoUpdate;
import com.challenge.alura.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Category> update(CategoryUpdate categoryUpdate, Long id) {

        try {
            Optional<Category> category1 = categoryRepository.findById(id);
            if(!category1.isEmpty()) {
                deleteVideo(category1.get().getId());
                Category category = new Category();

                category.setCor(categoryUpdate.getCor());
                category.setTitulo(categoryUpdate.getTitulo());
                category.setId(id);

                categoryRepository.save(category);
                return new ResponseEntity(category, HttpStatus.valueOf(200));

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (BadRequestException ex) {
            throw new BadRequestException("Fail to update video!", ex.getMessage());
        }

    }

}
