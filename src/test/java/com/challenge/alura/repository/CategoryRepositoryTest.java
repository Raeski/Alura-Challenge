package com.challenge.alura.repository;

import com.challenge.alura.model.Category;
import com.challenge.alura.model.Video;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Category Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("Save create category when Successful")
    void save_PersistCategory_WhenSuccessful(){
        Category categoryToBeSaved = createCategory();
        Category savedCategory = this.categoryRepository.save(categoryToBeSaved);
        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isNotNull();
        Assertions.assertThat(savedCategory.getTitulo()).isEqualTo(categoryToBeSaved.getTitulo());
    }

    @Test
    @DisplayName("Save update category when Successful")
    void save_UpdateCategory_WhenSuccessful() {
        Category categoryToBeSaved = createCategory();
        Category savedCategory = this.categoryRepository.save(categoryToBeSaved);

        savedCategory.setCor("Vermelho");

        Category categoryUpdate = this.categoryRepository.save(savedCategory);
        Assertions.assertThat(categoryUpdate).isNotNull();
        Assertions.assertThat(categoryUpdate.getCor().equals(savedCategory.getCor()));
    }

    @Test
    @DisplayName("Delete removes category when Successful")
    void delete_RemovesCategory_WhenSuccessful(){
        Category categoryBeSaved = createCategory();

        Category categorySaved = this.categoryRepository.save(categoryBeSaved);

        this.categoryRepository.delete(categorySaved);

        Optional<Category> categoryOptional = this.categoryRepository.findById(categorySaved.getId());

        Assertions.assertThat(categoryOptional.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Find by id category when Sucessful")
    void findById_ReturnCategory_WhenSuccessful(){
        Category categoryToBeSaved = createCategory();
        Category savedCategory = this.categoryRepository.save(categoryToBeSaved);

        Long id = savedCategory.getId();

        Optional<Category> byId = this.categoryRepository.findById(id);

        Assertions.assertThat(byId.equals(savedCategory.getId()));
        Assertions.assertThat(byId).isNotNull();
    }

    private Category createCategory(){
        Category createCategory = new Category() ;
        createCategory.setTitulo("Titulo categoria");
        createCategory.setCor("Preto");
        return createCategory;
    }



}