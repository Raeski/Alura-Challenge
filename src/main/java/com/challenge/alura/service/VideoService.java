package com.challenge.alura.service;

import com.challenge.alura.model.Video;
import com.challenge.alura.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public ResponseEntity<Video> create(Video video)   {
        videoRepository.save(video);
        return new ResponseEntity(video, HttpStatus.CREATED );
    }

    public ResponseEntity<Video> getVideos() {
        List<Video> all = videoRepository.findAll();
        return new ResponseEntity(all,HttpStatus.valueOf(200));
    }


    public ResponseEntity<Video> getVideo(Long id) {
        Optional<Video> byId = videoRepository.findById(id);
        return new ResponseEntity(byId, HttpStatus.valueOf(200));
    }
}
