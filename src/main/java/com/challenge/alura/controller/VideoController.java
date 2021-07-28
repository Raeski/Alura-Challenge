package com.challenge.alura.controller;

import com.challenge.alura.model.Video;
import com.challenge.alura.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody Video video ) {
        return videoService.create(video);
    }


}
