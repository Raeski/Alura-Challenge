package com.challenge.alura.repository;

import com.challenge.alura.model.Category;
import com.challenge.alura.model.Video;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for Video Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VideoRepositoryTest {

    @Autowired
    private VideoRepository videoRepository;


    @Test
    @DisplayName("Save create video when Successful")
    @AutoConfigureTestDatabase
    void save_PersistVideo_WhenSuccessful(){
        Video video = createVideo();
        Video savedVideo = this.videoRepository.save(video);
        Assertions.assertThat(savedVideo).isNotNull();
        Assertions.assertThat(savedVideo.getId()).isNotNull();
        Assertions.assertThat(savedVideo.getTitulo()).isEqualTo(video.getTitulo());
    }


    @Test
    @DisplayName("Save updates video when Successful")
    @AutoConfigureTestDatabase
    void save_UpdateVideo_WhenSuccessful(){
        Video video = createVideo();
        Video savedVideo = this.videoRepository.save(video);

        savedVideo.setTitulo("Titulo alterado");

        Video updateVideo = this.videoRepository.save(savedVideo);
        Assertions.assertThat(updateVideo).isNotNull();
        Assertions.assertThat(updateVideo.getId()).isNotNull();
        Assertions.assertThat(updateVideo.getTitulo()).isEqualTo(savedVideo.getTitulo());
    }

    private Video createVideo(){
        Video createVideo = new Video();
        createVideo.setDescricao("Descrição de teste");
        createVideo.setUrl("www.urlteste.com.br");
        createVideo.setTitulo("Titulo de teste");
        createVideo.setCategory(new Category());
        return createVideo;

    }



}