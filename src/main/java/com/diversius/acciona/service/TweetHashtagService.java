package com.diversius.acciona.service;

import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.entity.TweetHashtag;
import twitter4j.HashtagEntity;

public interface TweetHashtagService {

    void save(TweetHashtag tweetHashtag);

    void saveTweetHashtags(Tweet tweet, HashtagEntity[] hashtagEntities);

}
