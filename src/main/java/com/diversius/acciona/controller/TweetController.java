package com.diversius.acciona.controller;

import com.diversius.acciona.controller.response.tweet.TweetResponse;
import com.diversius.acciona.controller.response.tweet.TweetResponseBuilder;
import com.diversius.acciona.useCase.tweet.approveTweet.ApproveTweetInput;
import com.diversius.acciona.useCase.tweet.approveTweet.ApproveTweetUseCase;
import com.diversius.acciona.useCase.tweet.getTweets.GetTweetsOutput;
import com.diversius.acciona.useCase.tweet.getTweets.GetTweetsUseCase;
import com.diversius.acciona.useCase.tweet.getUserApprovedTweets.GetUserApprovedTweetsInput;
import com.diversius.acciona.useCase.tweet.getUserApprovedTweets.GetUserApprovedTweetsOutput;
import com.diversius.acciona.useCase.tweet.getUserApprovedTweets.GetUserApprovedTweetsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tweets")
public class TweetController {

    @Autowired
    private GetTweetsUseCase getTweetsUseCase;
    @Autowired
    private GetUserApprovedTweetsUseCase getUserApprovedTweetsUseCase;
    @Autowired
    private ApproveTweetUseCase approveTweetUseCase;

    @GetMapping
    public List<TweetResponse> getTweets() {
        GetTweetsOutput output = getTweetsUseCase.execute();
        return TweetResponseBuilder.getTweetResponses(output.getTweets());
    }

    @GetMapping("/approved/user/{hash}")
    public List<TweetResponse> getUserApprovedTweets(@PathVariable String hash) {
        GetUserApprovedTweetsOutput output = getUserApprovedTweetsUseCase.execute(new GetUserApprovedTweetsInput(hash));
        return TweetResponseBuilder.getTweetResponses(output.getTweets());
    }

    @PutMapping("{hash}/approve")
    public void approveTweet(@PathVariable String hash) {
        approveTweetUseCase.execute(new ApproveTweetInput(hash));
    }

}
