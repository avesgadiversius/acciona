package com.diversius.acciona.service.impl;

import com.diversius.acciona.dto.HashtagDTO;
import com.diversius.acciona.entity.Hashtag;
import com.diversius.acciona.repository.HashtagRepository;
import com.diversius.acciona.repository.TweetHashtagRepository;
import com.diversius.acciona.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HashtagServiceImpl implements HashtagService {

    static final int RANKING = 10;

    @Autowired
    private HashtagRepository hashtagRepository;
    @Autowired
    private TweetHashtagRepository tweetHashtagRepository;

    @Override
    public void save(Hashtag hashtag) {
        hashtagRepository.save(hashtag);
    }

    @Override
    public Hashtag createHashtag(String text) {
        Hashtag hashtag = new Hashtag(text);
        save(hashtag);

        return hashtag;
    }

    @Override
    public Hashtag getHashtagByText(String text) {
        return hashtagRepository.findFirstByTextAndDeletedFalse(text);
    }

    @Override
    public List<HashtagDTO> getRanking() {
        List<Hashtag> hashtags = hashtagRepository.findRanking();
        List<HashtagDTO> hashtagDTOs = new ArrayList<>();
        for (Hashtag hashtag : hashtags) {
            HashtagDTO hashtagDTO = new HashtagDTO(hashtag)
                    .setUsedCount(tweetHashtagRepository.countByHashtagAndHashtagDeletedFalseAndTweetDeletedFalse(hashtag));
            hashtagDTOs.add(hashtagDTO);
        }
        return hashtagDTOs;
    }
}
