package com.challenge.alura.service;

import com.challenge.alura.model.Video;
import com.challenge.alura.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public ResponseEntity<Video> create(Video video) {
        videoRepository.save(video);
        return new ResponseEntity(video, HttpStatus.CREATED );
    }


}
