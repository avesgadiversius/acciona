package com.diversius.acciona.service.impl;

import com.diversius.acciona.entity.Hashtag;
import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.entity.TweetHashtag;
import com.diversius.acciona.repository.TweetHashtagRepository;
import com.diversius.acciona.service.HashtagService;
import com.diversius.acciona.service.TweetHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.HashtagEntity;

@Service
public class TweetHashtagServiceImpl implements TweetHashtagService {

    @Autowired
    private HashtagService hashtagService;
    @Autowired
    private TweetHashtagRepository tweetHashtagRepository;

    @Override
    public void save(TweetHashtag tweetHashtag) {
        tweetHashtagRepository.save(tweetHashtag);
    }

    @Override
    public void saveTweetHashtags(Tweet tweet, HashtagEntity[] hashtagEntities) {
        for (HashtagEntity hashtagEntity : hashtagEntities) {
            Hashtag hashtag = hashtagService.getHashtagByText(hashtagEntity.getText());
            if (hashtag == null) {
                hashtag = hashtagService.createHashtag(hashtagEntity.getText());
            }
            createTweetHashtag(tweet, hashtag);
        }
    }

    private void createTweetHashtag(Tweet tweet, Hashtag hashtag) {
        TweetHashtag tweetHashtag = new TweetHashtag(tweet, hashtag);
        save(tweetHashtag);
    }
}
