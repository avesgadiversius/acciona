package com.diversius.acciona.entity;

import com.diversius.acciona.util.HashUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT")
    private Long id;

    @Column(name = "hash", nullable = false, updatable = false)
    protected String hash;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "deleted", columnDefinition = "BIT")
    private boolean deleted;

    @Column(name = "created", updatable = false)
    private Date createdAt;

    @Column(name = "updated")
    private Date updatedAt;

    @OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TweetHashtag> tweetHashtags = new LinkedHashSet<>();

    public Hashtag() {
    }

    public Hashtag(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public String getText() {
        return text;
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
        this.deleted = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

}
