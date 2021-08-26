package com.diversius.acciona.dto;

import com.diversius.acciona.entity.Hashtag;

import java.util.Date;

public class HashtagDTO {

    private Long id;
    private String hash;
    private String text;
    private int usedCount;

    public HashtagDTO(Hashtag hashtag) {
        this.id = hashtag.getId();
        this.hash = hashtag.getHash();
        this.text = hashtag.getText();
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

    public int getUsedCount() {
        return usedCount;
    }

    public HashtagDTO setUsedCount(int usedCount) {
        this.usedCount = usedCount;
        return this;
    }
}
