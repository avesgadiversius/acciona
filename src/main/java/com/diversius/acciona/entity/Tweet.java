package com.diversius.acciona.entity;

import com.diversius.acciona.util.HashUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT")
    private Long id;

    @Column(name = "hash", nullable = false, updatable = false)
    protected String hash;

    @Column(name = "twitter_id", nullable = false)
    private String twitterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "text")
    private String text;

    @Column(name = "approved", columnDefinition = "BIT")
    private boolean approved;

    @Column(name = "deleted", columnDefinition = "BIT")
    private boolean deleted;

    @Column(name = "created", updatable = false)
    private Date createdAt;

    @Column(name = "updated")
    private Date updatedAt;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TweetHashtag> tweetHashtags = new LinkedHashSet<>();

    public Tweet() {
    }

    public Tweet(String twitterId, User user, String text) {
        this.twitterId = twitterId;
        this.user = user;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    public boolean isDeleted() {
        return deleted;
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
        this.approved = false;
        this.deleted = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

}
