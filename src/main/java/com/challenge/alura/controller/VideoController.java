package com.challenge.alura.controller;

import com.challenge.alura.model.Video;
import com.challenge.alura.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping
    private ResponseEntity<Video> createVideo(@Valid  @RequestBody Video video )   {
        return videoService.create(video);
    }

    @GetMapping
    private ResponseEntity<Video> searchVideos() {
        return videoService.getVideos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Video> searchVideo(@PathVariable Long id) {
        return videoService.getVideo(id);
    }

}
