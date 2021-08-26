package com.diversius.acciona.useCase.hashtag.getMostUsedHashtags;

import com.diversius.acciona.dto.HashtagDTO;

import java.util.List;

public class GetMostUsedHashtagsOutput {

    private List<HashtagDTO> hashtags;

    public GetMostUsedHashtagsOutput(List<HashtagDTO> hashtags) {
        this.hashtags = hashtags;
    }

    public List<HashtagDTO> getHashtags() {
        return hashtags;
    }
}
