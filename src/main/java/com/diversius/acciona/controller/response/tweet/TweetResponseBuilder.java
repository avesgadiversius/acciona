package com.diversius.acciona.controller.response.tweet;

import com.diversius.acciona.controller.response.user.UserResponse;
import com.diversius.acciona.controller.response.user.UserResponseBuilder;
import com.diversius.acciona.dto.TweetDTO;

import java.util.ArrayList;
import java.util.List;

public class TweetResponseBuilder {

    public static TweetResponse getTweetResponse(TweetDTO tweet) {
        UserResponse user = UserResponseBuilder.getUserResponse(tweet.getUser());
        return new TweetResponse(tweet, user);
    }

    public static List<TweetResponse> getTweetResponses(List<TweetDTO> tweets) {
        List<TweetResponse> tweetResponses = new ArrayList<>();
        for (TweetDTO tweet : tweets) {
            tweetResponses.add(getTweetResponse(tweet));
        }
        return tweetResponses;
    }

}
