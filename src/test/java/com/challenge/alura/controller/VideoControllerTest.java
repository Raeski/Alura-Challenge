package com.challenge.alura.controller;

import com.challenge.alura.service.VideoService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class VideoControllerTest {

    @InjectMocks
    VideoController videoController;

    @Mock
    VideoService videoService;





}