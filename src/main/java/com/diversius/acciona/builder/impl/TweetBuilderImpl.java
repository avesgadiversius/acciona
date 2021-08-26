package com.diversius.acciona.builder.impl;

import com.diversius.acciona.builder.TweetBuilder;
import com.diversius.acciona.builder.UserBuilder;
import com.diversius.acciona.dto.TweetDTO;
import com.diversius.acciona.dto.UserDTO;
import com.diversius.acciona.entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetBuilderImpl implements TweetBuilder {

    @Autowired
    private UserBuilder userBuilder;

    @Override
    public TweetDTO convertToTweetDTO(Tweet tweet) {
        UserDTO user = userBuilder.convertToUserDTO(tweet.getUser());

        return new TweetDTO(tweet, user);
    }

    @Override
    public List<TweetDTO> convertToTweetDTOs(List<Tweet> tweets) {
        List<TweetDTO> tweetDTOs = new ArrayList<>();
        for (Tweet tweet : tweets) {
            tweetDTOs.add(convertToTweetDTO(tweet));
        }

        return tweetDTOs;
    }
}
