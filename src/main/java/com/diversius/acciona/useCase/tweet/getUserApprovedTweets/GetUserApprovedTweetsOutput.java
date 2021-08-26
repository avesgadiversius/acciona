package com.diversius.acciona.useCase.tweet.getUserApprovedTweets;

import com.diversius.acciona.dto.TweetDTO;

import java.util.List;

public class GetUserApprovedTweetsOutput {

    private List<TweetDTO> tweets;

    public GetUserApprovedTweetsOutput(List<TweetDTO> tweets) {
        this.tweets = tweets;
    }

    public List<TweetDTO> getTweets() {
        return tweets;
    }

}
