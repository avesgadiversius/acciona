package com.diversius.acciona.controller.response.tweet;

import com.diversius.acciona.controller.response.user.UserResponse;
import com.diversius.acciona.dto.TweetDTO;

import static java.util.Objects.nonNull;

public class TweetResponse {

    private String hash;
    private String twitterId;
    private UserResponse user;
    private String text;
    private boolean approved;

    public TweetResponse(TweetDTO tweet, UserResponse user) {
        if (nonNull(tweet)) {
            this.hash = tweet.getHash();
            this.twitterId = tweet.getTwitterId();
            this.user = user;
            this.text = tweet.getText();
            this.approved = tweet.isApproved();
        }
    }

    public String getHash() {
        return hash;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public UserResponse getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public boolean isApproved() {
        return approved;
    }

}
