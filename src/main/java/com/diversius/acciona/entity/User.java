package com.diversius.acciona.entity;

import com.diversius.acciona.util.HashUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT")
    private Long id;

    @Column(name = "hash", nullable = false, updatable = false)
    protected String hash;

    @Column(name = "twitter_id", nullable = false)
    private String twitterId;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted", columnDefinition = "BIT")
    private boolean deleted;

    @Column(name = "created", updatable = false)
    private Date createdAt;

    @Column(name = "updated")
    private Date updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tweet> tweets = new LinkedHashSet<>();

    public User() {
    }

    public User(String twitterId, String name) {
        this.twitterId = twitterId;
        this.name = name;
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

    public String getName() {
        return name;
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
