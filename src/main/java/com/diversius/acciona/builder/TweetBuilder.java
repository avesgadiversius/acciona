package com.diversius.acciona.builder;

import com.diversius.acciona.dto.TweetDTO;
import com.diversius.acciona.entity.Tweet;

import java.util.List;

public interface TweetBuilder {

    TweetDTO convertToTweetDTO(Tweet tweet);

    List<TweetDTO> convertToTweetDTOs(List<Tweet> tweets);

}
