package com.seberino.jairapi.mapper;

import com.seberino.jairapi.entity.Tweet;
import io.github.redouane59.twitter.dto.tweet.TweetV2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TweetsMapper {
    public static Tweet toTweet(TweetV2.TweetData tweetData) {
        return Tweet.builder()
                .createdAt(LocalDateTime.now())
                .createdTweetTime(tweetData.getCreatedAt())
                .id(tweetData.getId())
                .message(tweetData.getText())
                .build();
    }

    public static List<Tweet> toListTweets(List<TweetV2.TweetData> tweets) {
        return tweets.stream().map(TweetsMapper::toTweet).collect(Collectors.toList());
    }
}
