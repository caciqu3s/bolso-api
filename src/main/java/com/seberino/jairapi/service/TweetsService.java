package com.seberino.jairapi.service;

import com.seberino.jairapi.entity.Tweet;
import com.seberino.jairapi.mapper.TweetsMapper;
import com.seberino.jairapi.repository.TweetsRepository;
import io.github.redouane59.twitter.TwitterClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TweetsService {

    private final TweetsRepository repository;
    private final TwitterClient twitterClient;

    @Scheduled(cron = "0 0 0 * * *")
    @EventListener(ApplicationReadyEvent.class)
    public List<Tweet> saveTweetsFromTwitter() {
        log.info("[saveTweetsFromTwitter] start method at {}", LocalDateTime.now());
        String userId = twitterClient.getUserFromUserName("jairbolsonaro").getId();
        List<Tweet> tweets = repository.saveAll(TweetsMapper.toListTweets(twitterClient.getUserTimeline(userId).getData()));
        log.info("[saveTweetsFromTwitter] end method at {}", LocalDateTime.now());

        return tweets;
    }

    public Tweet getRandomTweet() {
        return repository.getRandomTweet();
    }
}
