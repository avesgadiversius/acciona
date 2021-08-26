package com.diversius.acciona.useCase.tweet.getTweets;

import com.diversius.acciona.dto.TweetDTO;

import java.util.List;

public class GetTweetsOutput {

    private List<TweetDTO> tweets;

    public GetTweetsOutput(List<TweetDTO> tweets) {
        this.tweets = tweets;
    }

    public List<TweetDTO> getTweets() {
        return tweets;
    }

}
