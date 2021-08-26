package com.diversius.acciona.repository;

import com.diversius.acciona.entity.Tweet;
import com.diversius.acciona.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Long> {

    Tweet findByHashAndDeletedFalse(String hash);

    Tweet findByTwitterIdAndDeletedFalse(String twitterId);

    List<Tweet> findByUserAndApprovedTrueAndDeletedFalse(User user);

}
