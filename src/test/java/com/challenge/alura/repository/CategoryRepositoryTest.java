package com.challenge.alura.repository;

import com.challenge.alura.model.Category;
import com.challenge.alura.model.Video;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Category Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;


    private Category createCategory(){
        Category createCategory = new Category() ;
        createCategory.setTitulo("Titulo categoria");
        createCategory.setCor("Preto");
        return createCategory;
    }


}