package com.challenge.alura.repository;

import com.challenge.alura.model.Category;
import com.challenge.alura.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("FROM Video v where v.category = :category")
    List<Video> findVideoByCategory(@Param("category") Category category);


    List<Video> findByTitulo(String titulo);
}
