package com.diversius.acciona.useCase.tweet.getUserApprovedTweets;

import com.diversius.acciona.builder.TweetBuilder;
import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserApprovedTweetsUseCase {

    @Autowired
    private TweetBuilder tweetBuilder;
    @Autowired
    private TweetService tweetService;

    public GetUserApprovedTweetsOutput execute(GetUserApprovedTweetsInput input) {
        List<Tweet> tweets = tweetService.getUserApprovedTweets(input.getUserHash());

        return new GetUserApprovedTweetsOutput(tweetBuilder.convertToTweetDTOs(tweets));
    }
}
