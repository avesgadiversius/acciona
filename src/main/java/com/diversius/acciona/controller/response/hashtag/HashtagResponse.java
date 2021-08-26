package com.diversius.acciona.controller.response.hashtag;

import com.diversius.acciona.dto.HashtagDTO;

import static java.util.Objects.nonNull;

public class HashtagResponse {

    private String hash;
    private String text;
    private int usedCount;

    public HashtagResponse(HashtagDTO hashtag) {
        if (nonNull(hashtag)) {
            this.hash = hashtag.getHash();
            this.text = hashtag.getText();
            this.usedCount = hashtag.getUsedCount();
        }
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
}
