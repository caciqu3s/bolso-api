package com.seberino.jairapi.repository;

import com.seberino.jairapi.entity.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TweetsRepository {
    private final MongoTemplate mongoTemplate;

    public Tweet getRandomTweet() {
        SampleOperation matchStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(matchStage);
        AggregationResults<Tweet> output = mongoTemplate.aggregate(aggregation, "tweet", Tweet.class);

        return output.getUniqueMappedResult();
    }

    public List<Tweet> saveAll(List<Tweet> tweets) {
        List<Tweet> savedTweets = new ArrayList<Tweet>();
        tweets.forEach(tweet -> savedTweets.add(mongoTemplate.save(tweet, "tweet")));

        return savedTweets;
    }
}
