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

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

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

    @Test
    @DisplayName("Delete removes video when Successful")
    void delete_RemovesVideo_WhenSuccessful(){
        Video videoToBeSaved = createVideo();

        Video videoSaved = this.videoRepository.save(videoToBeSaved);

        this.videoRepository.delete(videoSaved);

        Optional<Video> videoOptional = this.videoRepository.findById(videoSaved.getId());

        Assertions.assertThat(videoOptional.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Find by category video when Successful")
    void findByCategory_ReturnVideo_WhenSuccessful() {
        Video videoToBeSaved = createVideo();

        Video videoSaved = this.videoRepository.save(videoToBeSaved);

        Category category = videoSaved.getCategory();

        List<Video> videos = this.videoRepository.findVideoByCategory(category);

        Assertions.assertThat(videos).isNotEmpty();

    }

    @Test
    @DisplayName("Find by titulo returns list of video when Successful")
    void findByTitulo_ReturnVideo_WhenSuccessful() {
        Video videoToBeSaved = createVideo();

        Video videoSaved = this.videoRepository.save(videoToBeSaved);

        String titulo = videoSaved.getTitulo();

        List<Video> videos = this.videoRepository.findByTitulo(titulo);

        Assertions.assertThat(videos).isNotEmpty();
        Assertions.assertThat(videos.get(0).getTitulo().equals(titulo));

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