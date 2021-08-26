package com.diversius.acciona.service;

import com.diversius.acciona.entity.Tweet;
import twitter4j.Twitter;

import java.util.List;

public interface TweetService {

    void save(Tweet tweet);

    void saveRandomTweets();

    Twitter getTwitter();

    Tweet getTweetByHash(String hash);

    Tweet getTweetByHashOrException(String hash);

    List<Tweet> getTweets();

    void approveTweet(String hash);

    List<Tweet> getUserApprovedTweets(String userHash);

}
