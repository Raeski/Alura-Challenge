package com.challenge.alura.controller;

import com.challenge.alura.model.Video;
import com.challenge.alura.model.VideoUpdate;
import com.challenge.alura.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import java.util.Optional;

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
    private Video searchVideo(@PathVariable Long id){
        return videoService.getVideoById(id);
    }

    @GetMapping("/delete/{id}")
    private String deleteVideo(@PathVariable Long id){
        return videoService.delete(id);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody VideoUpdate videoUpdate){
        return videoService.update(videoUpdate, id);
    }

}
