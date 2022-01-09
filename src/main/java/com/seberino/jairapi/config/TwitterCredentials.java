package com.seberino.jairapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "twitter")
public class TwitterCredentials {
    private String accessToken;
    private String accessTokenSecret;
    private String apiKey;
    private String apiSecretKey;
}
