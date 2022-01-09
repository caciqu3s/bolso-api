package com.seberino.jairapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Tweet {
    @Id
    private String id;

    private String message;

    private LocalDateTime createdTweetTime;

    private LocalDateTime createdAt;
}
