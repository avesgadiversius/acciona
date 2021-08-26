package com.diversius.acciona.useCase.tweet.approveTweet;

public class ApproveTweetInput {

    private String hash;

    public ApproveTweetInput(
            String hash
    ) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

}
