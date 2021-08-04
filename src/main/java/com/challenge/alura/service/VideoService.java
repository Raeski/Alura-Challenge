package com.challenge.alura.service;

import com.challenge.alura.exception.BadRequestException;
import com.challenge.alura.model.Category;
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

    @Autowired
    private CategoryService categoryService;


    public ResponseEntity<Video> create(Video video)   {

        Category categoryById = categoryService.getCategoryById(video.getCategory().getId());
        try {
            video.setCategory(categoryById);

            videoRepository.save(video);
            return new ResponseEntity(video, HttpStatus.CREATED );
        } catch (BadRequestException ex) {
            throw new BadRequestException("Fail to create video");
        }

    }

    public ResponseEntity<List<Video>> getVideos() {

        try {
            List<Video> all = videoRepository.findAll();
            return new ResponseEntity(all,HttpStatus.valueOf(200));
        } catch (BadRequestException ex) {
            throw new BadRequestException("Fail to get videos", ex.getMessage());
        }

    }


    public Video getVideoById(Long id){
        return videoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Video not found!"));

    }

    public String delete(Long id) {
        Video video = getVideoById(id);
        try {
            videoRepository.deleteById(video.getId());
            return "Sucessful, video delete!";
        } catch (BadRequestException e) {
            throw new BadRequestException("Fail to delete video", e.getMessage());
        }
    }

    public ResponseEntity<Video> update(VideoUpdate videoUpdate, Long id) {

        try {
            Optional<Video> video1 = videoRepository.findById(id);
            if(!video1.isEmpty()) {
                delete(video1.get().getId());
                Video video = new Video();

                video.setUrl(videoUpdate.getUrl());
                video.setTitulo(videoUpdate.getTitulo());
                video.setDescricao(videoUpdate.getDescricao());
                video.setId(id);

                videoRepository.save(video);
                return new ResponseEntity(video, HttpStatus.valueOf(200));

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (BadRequestException ex) {
            throw new BadRequestException("Fail to update video!", ex.getMessage());
        }

    }

    public List<Video> getVideoByCategory( Category id ) {

        return videoRepository.findVideoByCategory(id);

    }

    public ResponseEntity<List<Video>> getVideoByName(String titulo) {

        return new ResponseEntity(videoRepository.findByTitulo(titulo),HttpStatus.ACCEPTED);
    }
}
