package com.challenge.alura.util;

import com.challenge.alura.model.Category;
import com.challenge.alura.model.Video;

public class VideoCreator {


    public static Video createVideo(){
        Video createVideo = new Video();
        createVideo.setDescricao("Descrição de teste");
        createVideo.setUrl("www.urlteste.com.br");
        createVideo.setTitulo("Titulo de teste");
        createVideo.setCategory(new Category());
        return createVideo;
    }

    public static Video createValidVideo(){
        Video createVideo = new Video();
        createVideo.setDescricao("Descrição de teste");
        createVideo.setUrl("www.urlteste.com.br");
        createVideo.setTitulo("Titulo de teste");
        createVideo.setId(1L);
        createVideo.setCategory(new Category());
        return createVideo;
    }

    public static Video createUpdateVideo(){
        Video createVideo = new Video();
        createVideo.setDescricao("Descrição de teste 2");
        createVideo.setUrl("www.urlteste.com.br, update");
        createVideo.setTitulo("Titulo de teste, update");
        createVideo.setCategory(new Category());
        return createVideo;
    }





}
