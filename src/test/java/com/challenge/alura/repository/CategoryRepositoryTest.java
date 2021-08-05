package com.challenge.alura.repository;

import com.challenge.alura.model.Category;
import com.challenge.alura.model.Video;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Category Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("Save create category when Successful")
    @AutoConfigureTestDatabase
    void save_PersistCategory_WhenSuccessful(){
        Category categoryToBeSaved = createCategory();
        Category savedCategory = this.categoryRepository.save(categoryToBeSaved);
        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isNotNull();
        Assertions.assertThat(savedCategory.getTitulo()).isEqualTo(categoryToBeSaved.getTitulo());
    }

    private Category createCategory(){
        Category createCategory = new Category() ;
        createCategory.setTitulo("Titulo categoria");
        createCategory.setCor("Preto");
        return createCategory;
    }


}