package com.diversius.acciona.controller.response.hashtag;

import com.diversius.acciona.dto.HashtagDTO;

import java.util.ArrayList;
import java.util.List;

public class HashtagResponseBuilder {

    public static HashtagResponse getHashtagResponse(HashtagDTO hashtag) {
        return new HashtagResponse(hashtag);
    }

    public static List<HashtagResponse> getHashtagResponses(List<HashtagDTO> hashtags) {
        List<HashtagResponse> hashtagResponses = new ArrayList<>();
        for (HashtagDTO hashtag : hashtags) {
            hashtagResponses.add(getHashtagResponse(hashtag));
        }
        return hashtagResponses;
    }

}
