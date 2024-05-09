package com.video.bootstream.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class VideoService {

    public static final String FORMAT = "classpath:videos/%s.mp4";

    @Autowired
    private ResourceLoader resourceLoader;

    public byte[] getVideo(String title) throws IOException {
        String path = String.format(FORMAT, title);
        System.out.println(path);
        Resource resource = resourceLoader.getResource(path);
        FileInputStream fis = new FileInputStream(resource.getFile());
        byte[] data = new byte[fis.available()];
        fis.read(data);
        return data;

    }


    public Mono<Resource> getVideoMono(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
    }


}
