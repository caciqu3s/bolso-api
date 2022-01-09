package com.seberino.jairapi.controller;

import com.seberino.jairapi.entity.Tweet;
import com.seberino.jairapi.service.TweetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tweets")
public class TweetsController {

    private final TweetsService service;

    @GetMapping("/random")
    public ResponseEntity<Tweet> getRandomTweet() {
        return ResponseEntity.ok(service.getRandomTweet());
    }
}
