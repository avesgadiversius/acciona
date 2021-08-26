package com.diversius.acciona.useCase.tweet.getTweets;

import com.diversius.acciona.builder.TweetBuilder;
import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTweetsUseCase {

    @Autowired
    private TweetBuilder tweetBuilder;
    @Autowired
    private TweetService tweetService;

    public GetTweetsOutput execute() {
        List<Tweet> tweets = tweetService.getTweets();

        return new GetTweetsOutput(tweetBuilder.convertToTweetDTOs(tweets));
    }
}
