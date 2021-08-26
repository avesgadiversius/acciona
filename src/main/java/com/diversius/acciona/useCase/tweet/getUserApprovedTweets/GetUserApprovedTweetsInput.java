package com.diversius.acciona.useCase.tweet.getUserApprovedTweets;

public class GetUserApprovedTweetsInput {

    private String userHash;

    public GetUserApprovedTweetsInput(
        String userHash
    ) {
        this.userHash = userHash;
    }

    public String getUserHash() {
        return userHash;
    }

}
