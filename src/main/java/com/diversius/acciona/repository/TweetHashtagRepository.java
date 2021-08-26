package com.diversius.acciona.repository;

import com.diversius.acciona.entity.Hashtag;
import com.diversius.acciona.entity.TweetHashtag;
import org.springframework.data.repository.CrudRepository;

public interface TweetHashtagRepository extends CrudRepository<TweetHashtag, Long> {

    int countByHashtagAndHashtagDeletedFalseAndTweetDeletedFalse(Hashtag hashtag);

}
