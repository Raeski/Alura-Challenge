package com.challenge.alura.service;

import com.challenge.alura.exception.BadRequestException;
import com.challenge.alura.model.Video;
import com.challenge.alura.model.VideoUpdate;
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


    public Video getVideoById(Long id) throws Exception {
        return videoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Video not found!"));

    }

    public String delete(Long id) throws Exception {
        Video video = getVideoById(id);
        try {
            videoRepository.deleteById(video.getId());
            return "Video deletado";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public ResponseEntity<Video> update(VideoUpdate videoUpdate, Long id) throws Exception {

        Optional<Video> video1 = videoRepository.findById(id);
        Video video = new Video();

        video.setUrl(videoUpdate.getUrl());
        video.setTitulo(videoUpdate.getTitulo());
        video.setDescricao(videoUpdate.getDescricao());
        video.setId(id);

        videoRepository.save(video);

        return new ResponseEntity(video, HttpStatus.valueOf(200));


    }
}
