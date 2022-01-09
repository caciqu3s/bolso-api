package com.seberino.jairapi.config;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TwitterConfiguration {
    private final com.seberino.jairapi.config.TwitterCredentials credentials;
    @Bean
    public TwitterClient getTwitterClient() {
        return new TwitterClient(TwitterCredentials.builder()
                .accessToken(credentials.getAccessToken())
                .accessTokenSecret(credentials.getAccessTokenSecret())
                .apiKey(credentials.getApiKey())
                .apiSecretKey(credentials.getApiSecretKey())
                .build());
    }
}
