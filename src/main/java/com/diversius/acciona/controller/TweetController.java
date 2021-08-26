package com.diversius.acciona.controller;

import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @GetMapping
    public List<Tweet> getTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("/hashtag")
    public List<String> getMostUsedHashtags() {
        return null;
    }

    @GetMapping("/approved/user/{hash}")
    public List<Tweet> getUserApprovedTweets(
            @PathVariable String hash
    ) {
        return tweetService.getUserApprovedTweets(hash);
    }

    @PutMapping("{hash}/approve")
    public void approveTweet(@PathVariable String hash) {
        tweetService.approveTweet(hash);
    }

}
