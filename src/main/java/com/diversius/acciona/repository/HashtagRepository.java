package com.diversius.acciona.repository;

import com.diversius.acciona.entity.Hashtag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {

    Hashtag findFirstByTextAndDeletedFalse(String text);

    @Query(nativeQuery = true, value = "SELECT h.* " +
            "FROM tweet_hashtag th " +
            "LEFT OUTER JOIN hashtag h on h.id = th.hashtag_id " +
            "LEFT OUTER JOIN tweet t on t.id = th.tweet_id " +
            "WHERE h.deleted = false " +
            "AND t.deleted = false " +
            "GROUP BY th.hashtag_id " +
            "ORDER BY COUNT(th.*) DESC Limit 10"
    )
    List<Hashtag> findRanking();

}
