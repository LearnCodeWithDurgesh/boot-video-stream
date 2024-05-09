package com.video.bootstream.controller;

import com.video.bootstream.services.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class VideoController {


    @Autowired
    private VideoService videoService;

    @GetMapping("/video/{title}")
    public ResponseEntity<byte[]> getVideoData(@PathVariable String title) throws IOException {
        return ResponseEntity.ok(videoService.getVideo(title));
    }

    @GetMapping("/video/stream/{title}")
    public Mono<Resource> streamVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println(range);
        return videoService.getVideoMono(title);
    }


}
