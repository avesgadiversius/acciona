package com.diversius.acciona.useCase.tweet.approveTweet;

import com.diversius.acciona.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApproveTweetUseCase {

    @Autowired
    private TweetService tweetService;

    public void execute(ApproveTweetInput input) {
        tweetService.approveTweet(input.getHash());
    }
}
