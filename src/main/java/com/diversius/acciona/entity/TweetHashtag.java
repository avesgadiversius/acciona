package com.diversius.acciona.entity;

import com.diversius.acciona.util.HashUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tweet_hashtag")
public class TweetHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT")
    private Long id;

    @Column(name = "hash", nullable = false, updatable = false)
    protected String hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tweet_id", nullable = false)
    private Tweet tweet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id", nullable = false)
    private Hashtag hashtag;

    @Column(name = "created", updatable = false)
    private Date createdAt;

    @Column(name = "updated")
    private Date updatedAt;

    public TweetHashtag() {
    }

    public TweetHashtag(Tweet tweet, Hashtag hashtag) {
        this.tweet = tweet;
        this.hashtag = hashtag;
    }

    public Long getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public Hashtag getHashtag() {
        return hashtag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.hash = HashUtil.createHash();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

}
