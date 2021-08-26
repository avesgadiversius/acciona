package com.diversius.acciona.dto;

import com.diversius.acciona.entity.Tweet;

public class TweetDTO {

    private String hash;
    private String twitterId;
    private UserDTO user;
    private String text;
    private boolean approved;

    public TweetDTO(Tweet tweet, UserDTO user) {
        this.hash = tweet.getHash();
        this.twitterId = tweet.getTwitterId();
        this.user = user;
        this.text = tweet.getText();
        this.approved = tweet.isApproved();
    }

    public String getHash() {
        return hash;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public UserDTO getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public boolean isApproved() {
        return approved;
    }
}
