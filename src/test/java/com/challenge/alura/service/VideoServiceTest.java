package com.challenge.alura.service;

import com.challenge.alura.model.Video;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class VideoServiceTest {

    @Test
    void createVideo() {

        VideoService mock = Mockito.mock(VideoService.class);

        Video video = new Video();
        video.setDescricao("Teste teste");
        video.setTitulo("Teste teste");
        video.setUrl("www.teste.com.br");

        ResponseEntity<Video> videoCreate = mock.create(video);
        Assertions.assertTrue(videoCreate != null);





    }

    @Test
    void getVideos() {
        VideoService mock = Mockito.mock(VideoService.class);
        ResponseEntity<List<Video>> listVideos =  mock.getVideos();
        Assertions.assertTrue(listVideos == null);
    }

    @Test
    void getVideoById() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getVideoByCategory() {
    }

    @Test
    void getVideoByName() {
    }
}