package com.diversius.acciona.dto;

import com.diversius.acciona.entity.Hashtag;

public class HashtagDTO {

    private String hash;
    private String text;
    private int usedCount;

    public HashtagDTO(Hashtag hashtag) {
        this.hash = hashtag.getHash();
        this.text = hashtag.getText();
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
