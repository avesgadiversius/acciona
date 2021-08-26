package com.diversius.acciona.service.impl;

import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.entity.User;
import com.diversius.acciona.repository.TweetRepository;
import com.diversius.acciona.service.TweetHashtagService;
import com.diversius.acciona.service.TweetService;
import com.diversius.acciona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TweetServiceImpl implements TweetService {

    static final String CONSUMER_KEY = "C3hgxAvCEFoZMe8Sr2AAdaXgG";
    static final String CONSUMER_SECRET = "ehbPbYqFqykRDgzSiD8dA3Qu09pgbU3dKmo32sTcUT01mMw3lr";
    static final String ACCESS_TOKEN = "1430418387851784192-kuZUXDHFqzvfu9wNX6i6EzDkcSzk6Z";
    static final String ACCESS_TOKEN_SECRET = "2QzS5FGJuUJWYMZFMYISLZrEETUK7MSdKiGJGVn4sAdkG";
    static final int MIN_FOLLOWERS = 1500;
    static final ArrayList<String> LANGUAGES = new ArrayList<String>() {{
        add("es");
        add("en");
        add("it");
    }};

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private TweetHashtagService tweetHashtagService;
    @Autowired
    private UserService userService;

    @Override
    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    @Override
    public void saveRandomTweets() {
        Twitter twitter = getTwitter();
        try {
            Query query = new Query(getRandom());
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                if (status.getUser().getFollowersCount() >= MIN_FOLLOWERS && LANGUAGES.contains(status.getLang()) && !status.isRetweet()) {
                    saveRandomTweet(status);
                    System.out.println("@" + status.getUser().getScreenName() + " (" + status.getUser().getFollowersCount() + ")" + ":" + status.getText());
                }
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Twitter getTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    @Override
    public Tweet getTweetByHash(String hash) {
        return tweetRepository.findByHashAndDeletedFalse(hash);
    }

    @Override
    public Tweet getTweetByHashOrException(String hash) {
        Tweet tweet = getTweetByHash(hash);
        if (tweet == null) {
            throw new EntityNotFoundException("Tweet not found.");
        }

        return tweet;
    }

    @Override
    public List<Tweet> getTweets() {
        return (List<Tweet>) tweetRepository.findAll();
    }

    @Override
    public void approveTweet(String hash) {
        Tweet tweet = getTweetByHashOrException(hash);
        tweet.approve();
        save(tweet);
    }

    @Override
    public List<Tweet> getUserApprovedTweets(String userHash) {
        User user = userService.getUserByHashOrException(userHash);

        return tweetRepository.findByUserAndApprovedTrueAndDeletedFalse(user);
    }

    private String getRandom() {
        Random rnd = new Random();
        char c = (char) ('a' + rnd.nextInt(26));
        return String.valueOf(c);
    }

    private void saveRandomTweet(Status status) {
        Tweet createdTweet = tweetRepository.findByTwitterIdAndDeletedFalse(String.valueOf(status.getId()));
        if (createdTweet != null) {
            return;
        }
        User user = userService.getUserByTwitterId(String.valueOf(status.getUser().getId()));
        if (user == null) {
            user = userService.createUser(String.valueOf(status.getUser().getId()), status.getUser().getName());
        }
        createTweet(String.valueOf(status.getId()), user, status.getText(), status.getHashtagEntities());
    }

    private void createTweet(String twitterId, User user, String text, HashtagEntity[] hashtagEntities) {
        Tweet tweet = new Tweet(twitterId, user, text);
        save(tweet);
        if (hashtagEntities != null && hashtagEntities.length > 0) {
            tweetHashtagService.saveTweetHashtags(tweet, hashtagEntities);
        }
    }
}
